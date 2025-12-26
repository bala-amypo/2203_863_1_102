package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        if(product.getModelNumber() == null || product.getModelNumber().isEmpty()) {
            throw new IllegalArgumentException("Model number cannot be empty");
        }
        if(product.getCategory() == null || product.getCategory().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        if(product.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("Days before expiry cannot be negative");
        }

        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new RuntimeException("Product not found"); // exact test message
        }
        return product.get();
    }
}
