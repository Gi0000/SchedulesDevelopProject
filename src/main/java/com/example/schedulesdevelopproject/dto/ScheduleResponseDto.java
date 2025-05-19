package com.example.schedulesdevelopproject.dto;

import com.example.schedulesdevelopproject.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long scheduleId;
    private final String username;
    private final String title;
    private final String contents;

    public ScheduleResponseDto(Long scheduleId, String username, String title, String contents) {
        this.scheduleId = scheduleId;
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getScheduleId(),
                schedule.getUser().getUsername(),
                schedule.getTitle(),
                schedule.getContents()
        );
    }
}
