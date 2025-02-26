package com.wellness.bot.Wellness_bot.repository;

import model.BreakReminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreakReminderRepository extends JpaRepository<BreakReminder, Long> {
    List<BreakReminder> findByUserId(String userId);
}
