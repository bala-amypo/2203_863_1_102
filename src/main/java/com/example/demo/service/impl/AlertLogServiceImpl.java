package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository alertLogRepository;
    private final WarrantyRepository warrantyRepository;

    public AlertLogServiceImpl(AlertLogRepository alertLogRepository,
                               WarrantyRepository warrantyRepository) {
        this.alertLogRepository = alertLogRepository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public AlertLog addLog(Long warrantyId, String message) {
        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));

        AlertLog log = new AlertLog();
        log.setWarranty(warranty);
        log.setMessage(message);

        return alertLogRepository.save(log);
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        return alertLogRepository.findByWarrantyId(warrantyId);
    }
    
    public void generateExpiryAlerts(int daysAhead) {
        LocalDate today = LocalDate.now();
        LocalDate targetDate = today.plusDays(daysAhead);

        List<Warranty> expiringWarranties = warrantyRepository.findByExpiryDateBetween(today, targetDate);

        for (Warranty warranty : expiringWarranties) {
            String message = "Warranty for product '" + warranty.getProduct().getName() +
                    "' is expiring on " + warranty.getExpiryDate();
            addLog(warranty.getId(), message);
        }
    }
}
