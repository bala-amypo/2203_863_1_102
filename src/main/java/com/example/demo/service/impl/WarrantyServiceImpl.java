package com.example.demo.service.impl;

import com.example.demo.entity.Warranty;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    private WarrantyRepository warrantyRepository;

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        warranty.setUserId(userId);
        warranty.setProductId(productId);
        return warrantyRepository.save(warranty);
    }

    @Override
    public Warranty getWarranty(Long warrantyId) {
        Optional<Warranty> warrantyOpt = warrantyRepository.findById(warrantyId);
        return warrantyOpt.orElse(null);
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
}
