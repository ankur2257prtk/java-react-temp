package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "wellness_checkins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WellnessCheckin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    
    @Enumerated(EnumType.STRING)
    private Mood mood;

    private LocalDateTime date = LocalDateTime.now();

    public enum Mood {
        HAPPY, NEUTRAL, STRESSED
    }

    // Getters and Setters
}
