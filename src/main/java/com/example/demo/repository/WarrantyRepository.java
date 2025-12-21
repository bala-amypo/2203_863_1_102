package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    // For your expiry alert logic
    List<Warranty> findByExpiryDateBetween(LocalDate start, LocalDate end);

    // Add this line to check if serial number exists
    boolean existsBySerialNumber(String serialNumber);

    // Optional: if you want to find warranties by user
    List<Warranty> findByUserId(Long userId);
}
