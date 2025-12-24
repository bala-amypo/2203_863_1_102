package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

public class AlertLogServiceImpl {

    private final AlertLogRepository repo;
    private final WarrantyRepository wRepo;

    public AlertLogServiceImpl(AlertLogRepository r, WarrantyRepository w) {
        this.repo = r;
        this.wRepo = w;
    }

    public AlertLog addLog(Long wid, String msg) {
        wRepo.findById(wid).orElseThrow();
        AlertLog l = AlertLog.builder().message(msg).build();
        l.prePersist();
        return repo.save(l);
    }

    public List<AlertLog> getLogs(Long wid) {
        wRepo.findById(wid).orElseThrow();
        return repo.findByWarrantyId(wid);
    }
}
