package com.example.demo.repository;

import java.util.*;
import java.time.LocalDate;
import com.example.demo.entity.*;

public interface WarrantyRepository {
    Warranty save(Warranty w);
    Optional<Warranty> findById(Long id);
    List<Warranty> findByUserId(Long userId);
    boolean existsBySerialNumber(String serial);
    List<Warranty> findWarrantiesExpiringBetween(LocalDate from, LocalDate to);
}
