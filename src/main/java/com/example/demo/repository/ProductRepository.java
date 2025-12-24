package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface ProductRepository {
    Product save(Product p);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
