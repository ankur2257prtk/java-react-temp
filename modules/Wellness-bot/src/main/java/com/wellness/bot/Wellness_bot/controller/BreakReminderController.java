package com.wellness.bot.Wellness_bot.controller;

import com.wellness.bot.Wellness_bot.service.BreakReminderService;
import model.BreakReminder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/breaks")
public class BreakReminderController {

    private final BreakReminderService service;

    public BreakReminderController(BreakReminderService service) {
        this.service = service;
    }

    @PostMapping("/schedule")
    public void scheduleBreak(@RequestBody BreakReminder reminder) {
        service.scheduleBreakReminder(reminder);
    }

    @GetMapping("/{userId}")
    public List<BreakReminder> getReminders(@PathVariable String userId) {
        return service.getUserReminders(userId);
    }
}
