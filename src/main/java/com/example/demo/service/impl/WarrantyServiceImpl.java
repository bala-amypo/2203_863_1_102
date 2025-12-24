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
    public Warranty saveWarranty(Warranty warranty) {
        return warrantyRepository.save(warranty);
    }

    @Override
    public List<Warranty> getAllWarranties() {
        return warrantyRepository.findAll();
    }

    @Override
    public Warranty getWarrantyById(Long id) {
        return warrantyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteWarranty(Long id) {
        warrantyRepository.deleteById(id);
    }
}
