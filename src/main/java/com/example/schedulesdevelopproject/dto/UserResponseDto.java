package com.example.schedulesdevelopproject.dto;

import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long userId;
    private final String username;
    private final String email;

    public UserResponseDto(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
