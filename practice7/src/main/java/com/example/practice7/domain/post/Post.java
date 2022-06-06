package com.example.practice7.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Post {

    private int id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isNotice;
    private int userId;

    public PostDto toDto(){
        PostDto dto = new PostDto();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setContent(this.content);
        dto.setCreatedAt(this.createdAt);
        dto.setUpdatedAt(this.updatedAt);
        dto.setUserId(this.userId);
        return dto;
    }

    public PostForm toForm(){
        PostForm form = new PostForm();
        form.setId(this.id);
        form.setTitle(this.title);
        form.setContent(this.content);
        form.setNotice(this.isNotice);
        form.setUserId(this.userId);
        return form;
    }

}
