package com.example.demo.repository;

import com.example.demo.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    boolean existsBySerialNumber(String serialNumber);
    List<Warranty> findByUserId(Long userId);
    
    @Query("SELECT w FROM Warranty w WHERE w.expiryDate BETWEEN :start AND :end")
    List<Warranty> findWarrantiesExpiringBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);
}