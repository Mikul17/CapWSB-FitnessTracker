package pl.wsb.fitnesstracker.healthmetrics.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetrics;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsDto;

@Component
public class HealthMetricsMapper {

    public HealthMetricsDto toHealthMetricsDto(HealthMetrics metrics){
        return HealthMetricsDto.builder()
                .id(metrics.getId())
                .user(metrics.getUser())
                .date(metrics.getDate())
                .weight(metrics.getWeight())
                .height(metrics.getHeight())
                .heartRate(metrics.getHeartRate())
                .build();
    }
}
