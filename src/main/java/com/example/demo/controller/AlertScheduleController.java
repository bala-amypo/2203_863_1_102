package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class AlertScheduleController {

    private final AlertScheduleService alertScheduleService;

    public AlertScheduleController(AlertScheduleService alertScheduleService) {
        this.alertScheduleService = alertScheduleService;
    }

    @PostMapping
    public AlertSchedule create(@RequestBody AlertSchedule schedule) {
        return alertScheduleService.createSchedule(schedule);
    }

    @GetMapping
    public List<AlertSchedule> getAll() {
        return alertScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public AlertSchedule getById(@PathVariable Long id) {
        return alertScheduleService.getScheduleById(id);
    }
}
