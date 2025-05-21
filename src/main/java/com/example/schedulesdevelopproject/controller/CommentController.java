package com.example.schedulesdevelopproject.controller;

import com.example.schedulesdevelopproject.dto.CommentResponseDto;
import com.example.schedulesdevelopproject.dto.CreateCommentRequestDto;
import com.example.schedulesdevelopproject.dto.UpdateCommentRequestDto;
import com.example.schedulesdevelopproject.entity.Schedule;
import com.example.schedulesdevelopproject.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{schedule_id}")
    public ResponseEntity<List<CommentResponseDto>> findAll(
            @PathVariable("schedule_id") Long scheduleId
    ) {
        List<CommentResponseDto> commentResponseDtoList = commentService.findAll(scheduleId);
        return new ResponseEntity<>(commentResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{schedule_id}/{comment_id}")
    public ResponseEntity<CommentResponseDto> findById(
            @PathVariable("schedule_id") Long scheduleId,
            @PathVariable("comment_id") Long commentId
    ) {
        CommentResponseDto commentResponseDto = commentService.findById(scheduleId, commentId);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.OK);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateCommentRequestDto requestDto) {
        commentService.updateById(id, requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }



    @DeleteMapping("{comment_id}")
    public ResponseEntity<CommentResponseDto> deleteById(
            @PathVariable("comment_id") Long commentId
    ) {
        commentService.deleteById(commentId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
