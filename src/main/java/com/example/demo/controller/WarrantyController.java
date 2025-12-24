package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranties")
public class WarrantyController {

    private final WarrantyService warrantyService;

    public WarrantyController(WarrantyService warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping("/{userId}/{productId}")
    public Warranty register(@PathVariable Long userId,
                             @PathVariable Long productId,
                             @RequestBody Warranty warranty) {
        return warrantyService.registerWarranty(userId, productId, warranty);
    }

    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(@PathVariable Long userId) {
        return warrantyService.getUserWarranties(userId);
    }

    @GetMapping("/{warrantyId}")
    public Warranty getWarranty(@PathVariable Long warrantyId) {
        return warrantyService.getWarranty(warrantyId);
    }
}
