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
        // Ensure warranty exists
        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));

        AlertLog log = new AlertLog();
        log.setWarrantyId(warranty.getId()); // <-- use existing setter
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

        // Use repository method that exists
        List<Warranty> expiringWarranties = warrantyRepository.findByExpiryDateBetween(today, targetDate);

        for (Warranty warranty : expiringWarranties) {
            String productName = (warranty.getProductId() != null) ? 
                    "Product ID: " + warranty.getProductId() : "Unknown Product"; 
            // You can fetch full product if needed via ProductRepository

            String message = "Warranty for product '" + productName +
                    "' is expiring on " + warranty.getExpiryDate();
            addLog(warranty.getId(), message);
        }
    }
}
