package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.config.PasswordEncoder;
import com.example.schedulesdevelopproject.dto.*;
import com.example.schedulesdevelopproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto, HttpServletRequest request ) {
        LoginResponseDto loginResponseDto = userService.findLoginUserById(requestDto.getUserId());


        if (requestDto.getEmail().equals(loginResponseDto.getEmail()) &&
                passwordEncoder.matches(requestDto.getPassword(), loginResponseDto.getPassword())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", loginResponseDto.getEmail());
            return ResponseEntity.ok("Login success");
        }

        return ResponseEntity.status(401).body("Invalid email or password");
    }



    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(
            @RequestBody @Valid CreateUserRequestDto requestDto
    ) {
        UserResponseDto userResponseDto =
                userService.save(
                        requestDto.getUsername(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
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

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateUserRequestDto requestDto
            ) {
        userService.updateUserById(id, requestDto.getUsername(), requestDto.getEmail());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUserById(
            @PathVariable Long id
    ) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
