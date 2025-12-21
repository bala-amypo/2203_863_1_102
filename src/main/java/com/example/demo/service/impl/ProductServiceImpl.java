package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public Product addProduct(Product product) {
        product.setId(idCounter++);
        products.add(product);
        return product;
    }

    @Override
    public Product getProduct(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
