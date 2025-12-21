package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/warranties")
public class WarrantyController {

    @Autowired
    private WarrantyService warrantyService;

    @PostMapping("/register/{userId}/{productId}")
    public Warranty registerWarranty(@PathVariable Long userId,
                                     @PathVariable Long productId,
                                     @RequestBody Warranty warranty) {
        return warrantyService.registerWarranty(userId, productId, warranty);
    }

    @GetMapping("/{id}")
    public Warranty getWarranty(@PathVariable Long id) {
        return warrantyService.getWarranty(id);
    }

    @GetMapping("/user/{userId}")
    public List<Warranty> getUserWarranties(@PathVariable Long userId) {
        return warrantyService.getUserWarranties(userId);
    }
}
