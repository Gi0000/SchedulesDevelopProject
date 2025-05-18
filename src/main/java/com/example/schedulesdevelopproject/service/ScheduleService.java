package com.example.schedulesdevelopproject.service;

import com.example.schedulesdevelopproject.dto.ScheduleResponseDto;
import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto save(String username, String title, String contents) {
        Schedule schedule = new Schedule(username, title, contents);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                schedule.getScheduleId(),
                schedule.getUsername(),
                schedule.getTitle(),
                schedule.getContents());
    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
}
