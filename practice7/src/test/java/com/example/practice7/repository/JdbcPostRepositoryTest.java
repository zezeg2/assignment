package com.example.practice7.repository;

import com.example.practice7.domain.post.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcPostRepositoryTest {

    @Autowired PostRepository postRepository;
    @Test
    void create() {



//        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        Post post = new Post();
        post.setTitle("asdasd");
        post.setContent("asdasd");
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setNotice(true);
        post.setUserId(2);
        Post post1 = postRepository.create(post);
    }

    @Test
    void update() {
    }
}