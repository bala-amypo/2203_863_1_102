package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_schedules")
public class AlertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long warrantyId;
    private Integer daysBeforeExpiry;
    private Boolean enabled;

    public AlertSchedule() {}

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
 
    public Integer getDaysBeforeExpiry() {
        return daysBeforeExpiry;
    }
 
    public void setDaysBeforeExpiry(Integer daysBeforeExpiry) {
        this.daysBeforeExpiry = daysBeforeExpiry;
    }
 
    public Boolean getEnabled() {
        return enabled;
    }
 
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
