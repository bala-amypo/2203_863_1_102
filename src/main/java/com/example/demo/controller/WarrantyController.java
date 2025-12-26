package com.example.demo.controller;

import com.example.demo.entity.Warranty;
import com.example.demo.service.impl.WarrantyServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warranties")
@Tag(name = "Warranties")
public class WarrantyController {

    private final WarrantyServiceImpl warrantyService;

    @Autowired
    public WarrantyController(WarrantyServiceImpl warrantyService) {
        this.warrantyService = warrantyService;
    }

    @PostMapping("/register/{userId}/{productId}")
    @Operation(summary = "Register a new warranty")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Warranty> registerWarranty(@PathVariable Long userId, 
                                                     @PathVariable Long productId,
                                                     @RequestBody Warranty warranty) {
        Warranty savedWarranty = warrantyService.registerWarranty(userId, productId, warranty);
        return ResponseEntity.ok(savedWarranty);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get warranty by ID")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Warranty> getWarranty(@PathVariable Long warrantyId) {
        Warranty warranty = warrantyService.getWarranty(warrantyId);
        return ResponseEntity.ok(warranty);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get warranties for a user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Warranty>> getUserWarranties(@PathVariable Long userId) {
        List<Warranty> warranties = warrantyService.getUserWarranties(userId);
        return ResponseEntity.ok(warranties);
    }

    @DeleteMapping("/{warrantyId}")
    @Operation(summary = "Delete warranty (Admin only)")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteWarranty(@PathVariable Long warrantyId) {
        // Implementation would go here
        return ResponseEntity.ok().build();
    }
}