package com.example.demo.service.impl;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarrantyServiceImpl implements WarrantyService {

    private final List<Warranty> warranties = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        warranty.setId(idCounter++);
        warranty.setUserId(userId);
        warranty.setProductId(productId);
        warranties.add(warranty);
        return warranty;
    }

    @Override
    public Warranty getWarranty(Long id) {
        return warranties.stream().filter(w -> w.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Warranty> getUserWarranties(Long userId) {
        return warranties.stream().filter(w -> w.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
