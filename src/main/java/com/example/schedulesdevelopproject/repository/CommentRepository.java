package com.example.schedulesdevelopproject.repository;

import com.example.schedulesdevelopproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
