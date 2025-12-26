package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.impl.AlertScheduleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@Tag(name = "Alert Schedules")
public class AlertScheduleController {

    private final AlertScheduleServiceImpl alertScheduleService;

    @Autowired
    public AlertScheduleController(AlertScheduleServiceImpl alertScheduleService) {
        this.alertScheduleService = alertScheduleService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Create alert schedule")
    public ResponseEntity<AlertSchedule> createSchedule(@PathVariable Long warrantyId,
                                                       @RequestBody AlertSchedule schedule) {
        AlertSchedule savedSchedule = alertScheduleService.createSchedule(warrantyId, schedule);
        return ResponseEntity.ok(savedSchedule);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get schedules for warranty")
    public ResponseEntity<List<AlertSchedule>> getSchedules(@PathVariable Long warrantyId) {
        List<AlertSchedule> schedules = alertScheduleService.getSchedules(warrantyId);
        return ResponseEntity.ok(schedules);
    }
}