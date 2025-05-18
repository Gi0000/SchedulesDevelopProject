package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.dto.CreateScheduleRequestDto;
import com.example.schedulesdevelopproject.dto.ScheduleResponseDto;
import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getUsername(),
                        requestDto.getTitle(),
                        requestDto.getContents()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }
}
