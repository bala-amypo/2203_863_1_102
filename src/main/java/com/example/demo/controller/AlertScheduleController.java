package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertschedules")
public class AlertScheduleController {

    @Autowired
    private AlertScheduleService alertScheduleService;

    @PostMapping("/create/{userId}")
    public AlertSchedule createSchedule(@PathVariable Long userId, @RequestBody AlertSchedule schedule) {
        return alertScheduleService.createSchedule(userId, schedule);
    }

    @GetMapping("/all")
    public List<AlertSchedule> getAllSchedules() {
        return alertScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public AlertSchedule getScheduleById(@PathVariable Long id) {
        return alertScheduleService.getScheduleById(id);
    }
}
