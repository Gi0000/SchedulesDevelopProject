package com.example.schedulesdevelopproject.service;

import com.example.schedulesdevelopproject.dto.CreateUserRequestDto;
import com.example.schedulesdevelopproject.dto.ScheduleResponseDto;
import com.example.schedulesdevelopproject.dto.UserResponseDto;
import com.example.schedulesdevelopproject.entity.User;
import com.example.schedulesdevelopproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto save(String username, String email, String password) {
        User user = new User(username, email, password);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getEmail());
    }

    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    public UserResponseDto findUserById(Long id) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        return new UserResponseDto(
                findUser.getUserId(),
                findUser.getUsername(),
                findUser.getEmail()
        );
    }

    @Transactional
    public void updateUserById(Long id, String username, String email) {
        User findUser = userRepository.findByIdOrElseThrow(id);

        findUser.updateUser(username, email);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
