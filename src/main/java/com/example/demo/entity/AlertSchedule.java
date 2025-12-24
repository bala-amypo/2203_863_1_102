package com.example.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertSchedule {
    private Long id;
    private Integer daysBeforeExpiry;
    private boolean enabled;
}
