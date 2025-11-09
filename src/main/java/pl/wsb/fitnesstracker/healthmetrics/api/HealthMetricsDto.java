package pl.wsb.fitnesstracker.healthmetrics.api;

import lombok.Builder;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Builder
public record HealthMetricsDto(
        Long id,
        User user,
        LocalDate date,
        Double weight,
        Double height,
        Double heartRate
) {

}
