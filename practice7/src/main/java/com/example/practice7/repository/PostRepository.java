package com.example.practice7.repository;

import com.example.practice7.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post create(Post post);
    void update(Post post);
    void deleteById(int id);


    Optional<Post> findById(int id);
    List<Post> findAllFree(int page);
    List<Post> findAllNotice(int page);
    List<Post> findByTitleFree(String title, int page);
    List<Post> findByTitleNotice(String title, int page);
}
