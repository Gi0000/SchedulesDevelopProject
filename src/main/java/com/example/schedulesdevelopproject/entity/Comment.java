package com.example.schedulesdevelopproject.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false, columnDefinition = "longtext")
    private String commentContents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;


    public Comment(String contents, User user, Schedule schedule) {
        super();
        this.commentContents = contents;
        this.user = user;
        this.schedule = schedule;
    }

    Comment () {}
}
