package com.example.demo.service.impl;

import com.example.demo.entity.Warranty;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final WarrantyRepository warrantyRepository;

    public WarrantyServiceImpl(WarrantyRepository warrantyRepository) {
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        warranty.setUserId(userId);
        warranty.setProductId(productId);
        return warrantyRepository.save(warranty);
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId).orElse(null);
    }
}
