package com.example.schedulesdevelopproject.dto;

import com.example.schedulesdevelopproject.entity.Comment;
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

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getCommentId(),
                comment.getSchedule().getScheduleId(),
                comment.getUser().getUserId(),
                comment.getCommentContents()
        );
    }
}
