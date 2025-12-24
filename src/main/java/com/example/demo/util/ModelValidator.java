package com.example.demo.util;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Warranty;

public class ModelValidator {

    public static void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("User email cannot be null or empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("User password cannot be null or empty");
        }
    }
    public static void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (product.getModelNumber() == null || product.getModelNumber().isEmpty()) {
            throw new IllegalArgumentException("Product model number cannot be null or empty");
        }
        if (product.getCategory() == null || product.getCategory().isEmpty()) {
            throw new IllegalArgumentException("Product category cannot be null or empty");
        }
    }

    public static void validateWarranty(Warranty warranty) {
        if (warranty == null) {
            throw new IllegalArgumentException("Warranty cannot be null");
        }
        if (warranty.getPurchaseDate() == null) {
            throw new IllegalArgumentException("Warranty purchase date cannot be null");
        }
        if (warranty.getExpiryDate() == null) {
            throw new IllegalArgumentException("Warranty expiry date cannot be null");
        }
        if (warranty.getSerialNumber() == null || warranty.getSerialNumber().isEmpty()) {
            throw new IllegalArgumentException("Warranty serial number cannot be null or empty");
        }
    }
    public static void validateAlertSchedule(AlertSchedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("AlertSchedule cannot be null");
        }
        if (schedule.getDaysBeforeExpiry() <= 0) {
            throw new IllegalArgumentException("Days before expiry must be greater than 0");
        }
    }
}
