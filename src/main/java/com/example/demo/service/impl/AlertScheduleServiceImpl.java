package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository repository;

    public AlertScheduleServiceImpl(AlertScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlertSchedule createSchedule(Long userId, AlertSchedule schedule) {
        schedule.setUserId(userId);  
        return repository.save(schedule);
    }

    @Override
    public List<AlertSchedule> getAllSchedules() {
        return repository.findAll();
    }

    @Override
    public AlertSchedule getScheduleById(Long id) {
        Optional<AlertSchedule> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long userId) {
        return repository.findByUserId(userId); 
    }
}
