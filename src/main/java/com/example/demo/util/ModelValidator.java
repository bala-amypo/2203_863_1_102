package com.example.demo.util;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;
import com.example.demo.entity.AlertSchedule;

import java.time.LocalDate;

public class ModelValidator {

    public static void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User required");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email required");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password required");
        }
    }

    public static void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product required");
        }
        if (product.getModelNumber() == null || product.getModelNumber().isBlank()) {
            throw new IllegalArgumentException("Model number required");
        }
        if (product.getCategory() == null || product.getCategory().isBlank()) {
            throw new IllegalArgumentException("Category required");
        }
    }

    public static void validateWarranty(Warranty warranty) {
        if (warranty == null) {
            throw new IllegalArgumentException("Warranty required");
        }
        LocalDate purchase = warranty.getPurchaseDate();
        LocalDate expiry = warranty.getExpiryDate();
        if (purchase == null || expiry == null) {
            throw new IllegalArgumentException("Dates required");
        }
        if (!expiry.isAfter(purchase)) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }
        if (warranty.getSerialNumber() == null || warranty.getSerialNumber().isBlank()) {
            throw new IllegalArgumentException("Serial number required");
        }
    }

    public static void validateAlertSchedule(AlertSchedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("Schedule required");
        }
        if (schedule.getDaysBeforeExpiry() == null || schedule.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry must be >= 0");
        }
    }
}
