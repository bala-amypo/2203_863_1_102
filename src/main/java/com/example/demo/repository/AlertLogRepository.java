package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface AlertLogRepository {
    AlertLog save(AlertLog l);
    List<AlertLog> findByWarrantyId(Long id);
}
