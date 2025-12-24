package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;

public class WarrantyServiceImpl {

    private final WarrantyRepository wRepo;
    private final UserRepository uRepo;
    private final ProductRepository pRepo;

    public WarrantyServiceImpl(WarrantyRepository w, UserRepository u, ProductRepository p) {
        this.wRepo = w;
        this.uRepo = u;
        this.pRepo = p;
    }

    public Warranty registerWarranty(Long uid, Long pid, Warranty w) {
        if (!w.getExpiryDate().isAfter(w.getPurchaseDate())) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }
        if (wRepo.existsBySerialNumber(w.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number must be unique");
        }
        w.setUser(uRepo.findById(uid).orElseThrow());
        w.setProduct(pRepo.findById(pid).orElseThrow());
        return wRepo.save(w);
    }

    public List<Warranty> getUserWarranties(Long uid) {
        return wRepo.findByUserId(uid);
    }

    public Warranty getWarranty(Long id) {
        return wRepo.findById(id).orElseThrow();
    }
}
