package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Warranty;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    boolean existsBySerialNumber(String serialNumber);
    List<Warranty> findByUserId(Long userId);

    @Query("SELECT w FROM Warranty w WHERE w.expiryDate BETWEEN :from AND :to")
    List<Warranty> findWarrantiesExpiringBetween(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
