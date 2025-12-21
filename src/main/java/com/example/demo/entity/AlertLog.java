package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_logs")
public class AlertLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long warrantyId;
    private String message;
    private LocalDateTime sentAt;

    public AlertLog() {}

    @PrePersist
    public void onCreate() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Long getWarrantyId() {
        return warrantyId;
    }
 
    public void setWarrantyId(Long warrantyId) {
        this.warrantyId = warrantyId;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public LocalDateTime getSentAt() {
        return sentAt;
    }
 
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
