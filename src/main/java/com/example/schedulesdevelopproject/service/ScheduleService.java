package com.example.schedulesdevelopproject.service;

import com.example.schedulesdevelopproject.dto.ScheduleResponseDto;
import com.example.schedulesdevelopproject.dto.UpdateScheduleRequestDto;
import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.entity.User;
import com.example.schedulesdevelopproject.repository.ScheduleRepository;
import com.example.schedulesdevelopproject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    public ScheduleResponseDto save(Long userId, String title, String contents) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found. id = " + userId));

        Schedule schedule = new Schedule(user, title, contents);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                schedule.getScheduleId(),
                user.getUsername(),
                schedule.getTitle(),
                schedule.getContents());
    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(
                findSchedule.getScheduleId(),
                findSchedule.getUser().getUsername(),
                findSchedule.getTitle(),
                findSchedule.getContents());
    }

    @Transactional
    public void updateById(Long id, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.updateSchedule(title, contents);
    }



    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
