package com.example.demo.controller;

import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs")
@Tag(name = "Alert Logs")
public class AlertLogController {

    private final AlertLogService alertLogService;

    @Autowired
    public AlertLogController(AlertLogService alertLogService) {
        this.alertLogService = alertLogService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Add alert log")
    public ResponseEntity<AlertLog> addLog(@PathVariable Long warrantyId,
                                          @RequestBody Map<String, String> request) {
        String message = request.get("message");
        AlertLog savedLog = alertLogService.addLog(warrantyId, message);
        return ResponseEntity.ok(savedLog);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get logs for warranty")
    public ResponseEntity<List<AlertLog>> getLogs(@PathVariable Long warrantyId) {
        List<AlertLog> logs = alertLogService.getLogs(warrantyId);
        return ResponseEntity.ok(logs);
    }
}