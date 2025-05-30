package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.dto.CreateScheduleRequestDto;
import com.example.schedulesdevelopproject.dto.ScheduleResponseDto;
import com.example.schedulesdevelopproject.dto.UpdateScheduleRequestDto;
import com.example.schedulesdevelopproject.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody @Valid CreateScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getUserId(),
                        requestDto.getTitle(),
                        requestDto.getContents()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById (@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateScheduleRequestDto requestDto) {
        scheduleService.updateById(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteById (@PathVariable Long id) {
        scheduleService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
