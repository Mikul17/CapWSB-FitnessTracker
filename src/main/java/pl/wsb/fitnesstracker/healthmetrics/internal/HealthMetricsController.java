package pl.wsb.fitnesstracker.healthmetrics.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.fitnesstracker.healthmetrics.api.HealthMetricsDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health-metrics")
public class HealthMetricsController {

    private final HealthMetricsServiceImpl healthMetricsService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllHealthMetricsByUserId(@PathVariable Long userId){
        try{
            List<HealthMetricsDto> dto = healthMetricsService.findAllByUserId(userId);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.badRequest().body("Provided userId is not valid");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to fetch users");
        }
    }
}
