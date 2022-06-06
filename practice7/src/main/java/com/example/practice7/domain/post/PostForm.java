package com.example.practice7.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostForm {

    private int id;
    private String title;
    private String content;
    private boolean isNotice;
    private int userId;

}
