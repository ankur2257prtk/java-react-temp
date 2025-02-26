package model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "break_reminders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreakReminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "reminder_time", nullable = false)
    private LocalDateTime reminderTime;

    // Getters and Setters
}
