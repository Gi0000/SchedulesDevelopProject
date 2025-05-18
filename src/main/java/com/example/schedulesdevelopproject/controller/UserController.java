package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.dto.CreateUserRequestDto;
import com.example.schedulesdevelopproject.dto.UserResponseDto;
import com.example.schedulesdevelopproject.entity.User;
import com.example.schedulesdevelopproject.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUser() {
        List<UserResponseDto> userResponseDtoList = userService.findAllUser();
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(
            @PathVariable Long id
    ) {
        UserResponseDto userResponseDto = userService.findUserById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }


}
