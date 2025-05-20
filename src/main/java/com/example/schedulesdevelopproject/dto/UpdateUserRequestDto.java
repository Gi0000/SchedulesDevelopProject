package com.example.schedulesdevelopproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequestDto {
    @Size(max = 4, message = "유저명 4글자 이내")
    private String username;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
}
