package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alert-schedules")
public class AlertScheduleController {

    private final AlertScheduleService alertScheduleService;

    public AlertScheduleController(AlertScheduleService alertScheduleService) {
        this.alertScheduleService = alertScheduleService;
    }

    @PostMapping("/{warrantyId}")
    public AlertSchedule create(@PathVariable Long warrantyId,
                                @RequestBody AlertSchedule schedule) {
        return alertScheduleService.createSchedule(warrantyId, schedule);
    }

    @GetMapping("/{warrantyId}")
    public List<AlertSchedule> getAll(@PathVariable Long warrantyId) {
        return alertScheduleService.getSchedules(warrantyId);
    }
}
