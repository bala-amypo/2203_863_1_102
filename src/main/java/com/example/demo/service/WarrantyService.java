package com.example.demo.service;

import com.example.demo.entity.Warranty;
import java.util.List;

public interface WarrantyService {
    Warranty createWarranty(Warranty warranty);
    List<Warranty> getAllWarranties();
    Warranty getWarrantyById(Long id);
}
