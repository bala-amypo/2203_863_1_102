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
    private LocalDateTime sentAt;
    private String message;

    public AlertLog() {}

    public AlertLog(Long id, Long warrantyId, LocalDateTime sentAt, String message) {
        this.id = id;
        this.warrantyId = warrantyId;
        this.sentAt = sentAt;
        this.message = message;
    }

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getWarrantyId() { return warrantyId; }
    public void setWarrantyId(Long warrantyId) { this.warrantyId = warrantyId; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
