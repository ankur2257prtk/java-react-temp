package com.wellness.bot.Wellness_bot.service;

import com.wellness.bot.Wellness_bot.repository.WellnessCheckinRepository;
import model.WellnessCheckin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellnessCheckinService {

    private final WellnessCheckinRepository repository;

    public WellnessCheckinService(WellnessCheckinRepository repository) {
        this.repository = repository;
    }

    public WellnessCheckin saveCheckin(WellnessCheckin checkin) {
        return repository.save(checkin);
    }

    public List<WellnessCheckin> getUserCheckins(String userId) {
        return repository.findByUserId(userId);
    }
}
