package com.example.schedulesdevelopproject.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long commentId;
    private final Long scheduleId;
    private final Long userId;
    private final String commentContents;


    public CommentResponseDto(Long commentId, Long scheduleId, Long userId, String commentContents) {
        this.commentId = commentId;
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.commentContents = commentContents;
    }
}
