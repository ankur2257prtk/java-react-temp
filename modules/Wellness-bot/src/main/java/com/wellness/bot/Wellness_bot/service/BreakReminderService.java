package com.wellness.bot.Wellness_bot.service;

import com.wellness.bot.Wellness_bot.repository.BreakReminderRepository;
import model.BreakReminder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreakReminderService {

    private final BreakReminderRepository repository;

    public BreakReminderService(BreakReminderRepository repository) {
        this.repository = repository;
    }

    public void scheduleBreakReminder(BreakReminder reminder) {
        repository.save(reminder);
    }

    public List<BreakReminder> getUserReminders(String userId) {
        return repository.findByUserId(userId);
    }
}
