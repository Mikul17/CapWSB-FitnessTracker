package pl.wsb.fitnesstracker.healthmetrics.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetrics;

import java.util.List;
import java.util.Objects;


public interface HealthMetricsRepository extends JpaRepository<HealthMetrics, Long> {

    default List<HealthMetrics> findAllByUserId(Long userId) {
        return findAll().stream()
                .filter((healthMetrics ->
                        healthMetrics.getUser() != null && Objects.equals(healthMetrics.getUser().getId(), userId)))
                .toList();
    }
}
