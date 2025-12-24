package com.example.demo.service;

import com.example.demo.entity.AlertSchedule;
import java.util.List;

public interface AlertScheduleService {

    AlertSchedule createSchedule(Long userId, AlertSchedule schedule);

    List<AlertSchedule> getAllSchedules();

    AlertSchedule getScheduleById(Long id);

    List<AlertSchedule> getSchedules(Long userId);
}
