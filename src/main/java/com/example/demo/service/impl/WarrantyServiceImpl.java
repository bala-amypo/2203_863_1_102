package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.WarrantyService;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import java.util.*;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        if (warranty.getExpiryDate() == null || warranty.getPurchaseDate() == null)
            throw new IllegalArgumentException("Dates required");

        if (!warranty.getExpiryDate().isAfter(warranty.getPurchaseDate()))
            throw new IllegalArgumentException("Expiry date must be after purchase date");

        if (warrantyRepository.existsBySerialNumber(warranty.getSerialNumber()))
            throw new IllegalArgumentException("Serial number must be unique");

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        warranty.setUser(user);
        warranty.setProduct(product);

        return warrantyRepository.save(warranty);
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));
    }
}
