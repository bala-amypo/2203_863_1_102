package com.example.demo.entity;

public class AlertLog {
    private Long id;
    private Long warrantyId;
    private String message;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getWarrantyId() { return warrantyId; }
    public void setWarrantyId(Long warrantyId) { this.warrantyId = warrantyId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
