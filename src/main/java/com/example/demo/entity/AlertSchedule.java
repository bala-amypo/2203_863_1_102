package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int daysBeforeExpiry;

    private Long userId; 
    public AlertSchedule() {}

    public AlertSchedule(int daysBeforeExpiry, Long userId) {
        this.daysBeforeExpiry = daysBeforeExpiry;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public int getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }

    public void setDaysBeforeExpiry(int daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
