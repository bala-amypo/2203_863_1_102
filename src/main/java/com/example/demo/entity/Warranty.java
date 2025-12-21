package com.example.demo.entity;

import java.time.LocalDate;

public class Warranty {
    private Long id;
    private Long productId;
    private Long userId;              // required for setUserId()
    private LocalDate purchaseDate;   // required by WarrantyServiceImpl
    private LocalDate expiryDate;     // required by both AlertLogServiceImpl & WarrantyServiceImpl
    private String serialNumber;      // required for existsBySerialNumber()

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
}
