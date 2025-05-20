package com.example.schedulesdevelopproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    @NotNull(message = "사용자 아이디 입력 필수")
    private final Long userId;

    @NotNull(message = "제목 입력 필수")
    @Size(max = 10, message = "제목은 10글자 이내")
    private final String title;

    @NotBlank(message = "내용 입력 필수")
    private final String contents;

    public CreateScheduleRequestDto(Long userId, String title, String contents) {
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
}
