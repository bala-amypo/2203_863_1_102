package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

public class AlertScheduleServiceImpl {

    private final AlertScheduleRepository repo;
    private final WarrantyRepository wRepo;

    public AlertScheduleServiceImpl(AlertScheduleRepository r, WarrantyRepository w) {
        this.repo = r;
        this.wRepo = w;
    }

    public AlertSchedule createSchedule(Long wid, AlertSchedule s) {
        if (s.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry");
        }
        wRepo.findById(wid).orElseThrow();
        return repo.save(s);
    }

    public List<AlertSchedule> getSchedules(Long wid) {
        wRepo.findById(wid).orElseThrow();
        return repo.findByWarrantyId(wid);
    }
}
