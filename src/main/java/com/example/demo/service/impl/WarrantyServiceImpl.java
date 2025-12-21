package com.example.demo.service.impl;

import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;
List<Warranty> expiringWarranties = warrantyRepository.findByExpiryDateBetween(startDate, endDate);


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepository,
                               UserRepository userRepository,
                               ProductRepository productRepository) {
        this.warrantyRepository = warrantyRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {

        userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        if (!warranty.getExpiryDate().isAfter(warranty.getPurchaseDate())) {
            throw new IllegalArgumentException(
                    "Expiry date must be after purchase date");
        }

        if (warrantyRepository.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new IllegalArgumentException(
                    "Serial number must be unique");
        }

        warranty.setUserId(userId);
        warranty.setProductId(productId);

        return warrantyRepository.save(warranty);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Warranty not found"));
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
}
