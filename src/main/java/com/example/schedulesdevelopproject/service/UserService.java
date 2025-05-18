package com.example.schedulesdevelopproject.service;

import com.example.schedulesdevelopproject.dto.CreateUserRequestDto;
import com.example.schedulesdevelopproject.dto.UserResponseDto;
import com.example.schedulesdevelopproject.entity.User;
import com.example.schedulesdevelopproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto save(String username, String email) {
        User user = new User(username, email);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail());
    }
}
