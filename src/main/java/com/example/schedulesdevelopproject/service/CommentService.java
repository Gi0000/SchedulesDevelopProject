package com.example.schedulesdevelopproject.service;

import com.example.schedulesdevelopproject.repository.CommentRepository;
import com.example.schedulesdevelopproject.repository.ScheduleRepository;
import com.example.schedulesdevelopproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }
}
