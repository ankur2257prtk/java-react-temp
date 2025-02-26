package com.wellness.bot.Wellness_bot.controller;

import com.wellness.bot.Wellness_bot.service.WellnessCheckinService;
import model.WellnessCheckin;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/wellness")
public class WellnessCheckinController {

    private final WellnessCheckinService service;

    public WellnessCheckinController(WellnessCheckinService service) {
        this.service = service;
    }

    @PostMapping("/checkin")
    public WellnessCheckin submitCheckin(@RequestBody WellnessCheckin checkin) {
        return service.saveCheckin(checkin);
    }

    @GetMapping("/{userId}")
    public List<WellnessCheckin> getUserCheckins(@PathVariable String userId) {
        return service.getUserCheckins(userId);
    }
}
