package com.example.schedulesdevelopproject.dto;

import com.example.schedulesdevelopproject.entity.User;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    private final Long userId;
    private final String email;
    private final String password;

    public LoginRequestDto(Long userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }
}
