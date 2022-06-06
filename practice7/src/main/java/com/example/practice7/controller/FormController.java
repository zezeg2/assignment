package com.example.practice7.controller;

import com.example.practice7.domain.post.Post;
import com.example.practice7.domain.post.PostForm;
import com.example.practice7.domain.user.UserForm;
import com.example.practice7.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FormController {

    private final PostRepository postRepository;

    @GetMapping("/usr/member/login")
    public String login(Model model){
        model.addAttribute(new UserForm());
        return "/usr/member/loginForm";
    }

    @GetMapping("/usr/article/modify")
    public String updatePost(@RequestParam int id, Model model){
        Post post = postRepository.findById(id).get();
        model.addAttribute(post.toForm());
        return "/usr/article/postForm";
    }

    @GetMapping("/usr/article/write")
    public String createPost(@RequestParam int boardId, Model model){
        PostForm form = new PostForm();
        if (boardId==1) {
            form.setNotice(true);
        } else{
            form.setNotice(false);
        }
        model.addAttribute(form);
        return "/usr/article/postForm";
    }
}
