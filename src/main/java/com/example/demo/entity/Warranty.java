package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "warranties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warranty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    
    private LocalDate purchaseDate;
    
    private LocalDate expiryDate;
    
    @Column(unique = true)
    private String serialNumber;
    
    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlertSchedule> alertSchedules;
    
    @OneToMany(mappedBy = "warranty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlertLog> alertLogs;
}
