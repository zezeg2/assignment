package com.example.practice7.controller;

import com.example.practice7.domain.post.Post;
import com.example.practice7.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usr/home")
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;

    @GetMapping( "/main")
    public List<Post> index(@RequestParam String type){
        return postService.getRecentPost(type);

    }
}
