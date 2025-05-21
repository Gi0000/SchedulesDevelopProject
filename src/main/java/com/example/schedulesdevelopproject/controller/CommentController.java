package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.dto.CommentResponseDto;
import com.example.schedulesdevelopproject.dto.CreateCommentRequestDto;
import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{schedule_id}")
    public ResponseEntity<CommentResponseDto> save(
            @PathVariable("schedule_id") Long scheduleId,
            @RequestBody @Valid CreateCommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto =
                commentService.save(
                        scheduleId,
                        requestDto.getUserId(),
                        requestDto.getContents()
                );
        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }



}
