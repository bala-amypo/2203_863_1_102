package com.example.demo.entity;

import java.time.LocalDate;

public class Warranty {
    private Long id;
    private Long productId;
    private LocalDate purchaseDate;   // Add this field
    private String serialNumber;      // Add this field

    // Existing getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    // New getters and setters
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
}
