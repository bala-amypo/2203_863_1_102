package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface AlertScheduleRepository {
    AlertSchedule save(AlertSchedule s);
    List<AlertSchedule> findByWarrantyId(Long id);
}
