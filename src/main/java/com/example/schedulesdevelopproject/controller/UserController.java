package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.dto.CreateUserRequestDto;
import com.example.schedulesdevelopproject.dto.UserResponseDto;
import com.example.schedulesdevelopproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(
            @RequestBody CreateUserRequestDto requestDto
    ) {
        UserResponseDto userResponseDto =
                userService.save(
                        requestDto.getUsername(),
                        requestDto.getEmail()
                );
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }


}
