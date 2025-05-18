package com.example.schedulesdevelopproject.repository;

import com.example.schedulesdevelopproject.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
