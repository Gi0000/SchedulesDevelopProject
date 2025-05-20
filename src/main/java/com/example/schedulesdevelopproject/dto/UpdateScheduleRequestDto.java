package com.example.schedulesdevelopproject.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    @Size(max = 10, message = "제목 10글자 이내")
    private String title;

    private String contents;
}
