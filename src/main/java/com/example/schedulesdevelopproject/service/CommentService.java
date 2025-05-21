package com.example.schedulesdevelopproject.service;

import com.example.schedulesdevelopproject.dto.CommentResponseDto;
import com.example.schedulesdevelopproject.entity.Comment;
import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.entity.User;
import com.example.schedulesdevelopproject.repository.CommentRepository;
import com.example.schedulesdevelopproject.repository.ScheduleRepository;
import com.example.schedulesdevelopproject.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public CommentResponseDto save(Long scheduleId, Long userId, String contents) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        User user = userRepository.findByIdOrElseThrow(userId);
        Comment comment = new Comment(contents, user, schedule);
        commentRepository.save(comment);

        return new CommentResponseDto(
                comment.getCommentId(),
                scheduleId,
                userId,
                comment.getCommentContents()
        );
    }

    public List<CommentResponseDto> findAll(Long scheduleId) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        List<Comment> comments = commentRepository.findAllBySchedule(schedule);

        return comments.stream().map(CommentResponseDto::toDto).toList();

    }
}
