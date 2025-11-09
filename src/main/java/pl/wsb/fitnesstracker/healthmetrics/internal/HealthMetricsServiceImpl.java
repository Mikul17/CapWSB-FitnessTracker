package pl.wsb.fitnesstracker.healthmetrics.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsDto;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsProvider;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthMetricsServiceImpl implements HealthMetricsProvider {

    private final HealthMetricsRepository repository;
    private final HealthMetricsMapper mapper;

    @Transactional(readOnly = true)
    public List<HealthMetricsDto> findAllByUserId(Long userId){
        if(userId == null){
            throw new IllegalArgumentException("User id cannot be null");
        }

        return repository.findAllByUserId(userId).stream()
                .map(mapper::toHealthMetricsDto)
                .toList();
    }
}