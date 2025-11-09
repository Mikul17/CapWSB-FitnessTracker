package pl.wsb.fitnesstracker.healthmetrics.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;

@Entity
@Table(name = "health_metrics")
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Nullable
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "weight", nullable = false)
    private Double weight;
    @Column(name = "height", nullable = false)
    private Double height;
    @Column(name = "heart_rate", nullable = false)
    private Double heartRate;
}
