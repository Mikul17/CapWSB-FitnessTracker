package pl.wsb.fitnesstracker.healthmetrics.api;

import java.util.List;

public interface HealthMetricsProvider {

     List<HealthMetricsDto> findAllByUserId(Long userId);
}
