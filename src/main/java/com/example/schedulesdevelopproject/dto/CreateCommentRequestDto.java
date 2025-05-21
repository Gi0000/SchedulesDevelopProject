package com.example.schedulesdevelopproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateCommentRequestDto {
    @NotNull(message = "사용자 아이디 입력 필수")
    private final Long userId;

    @NotBlank(message = "내용 입력 필수")
    private final String contents;

    public CreateCommentRequestDto(Long userId, String contents) {
        this.userId = userId;
        this.contents = contents;
    }
}
