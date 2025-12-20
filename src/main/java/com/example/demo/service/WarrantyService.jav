package com.example.demo.service;

import com.example.demo.entity.Warranty;
import java.util.List;

public interface WarrantyService {

    Warranty createWarranty(Warranty warranty, Long userId, Long productId);

    Warranty getWarrantyById(Long id);

    List<Warranty> getAllWarranties();

    void deleteWarranty(Long id);
}
