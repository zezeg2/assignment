package com.example.practice7.controller;

import com.example.practice7.domain.post.Post;
import com.example.practice7.domain.post.PostDto;
import com.example.practice7.domain.post.PostForm;
import com.example.practice7.domain.user.User;
import com.example.practice7.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(("/usr/article"))
@RequiredArgsConstructor
public class ArticleController {
    private final PostService postService;

    @GetMapping("/list")
    public List<Post> listWithKeyword(
            @RequestParam(required = true) Integer boardId,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String searchKeyword) {
        if (page == null) {
            if (searchKeyword == null) {
                return postService.getPostList(boardId);
            } else {
                return postService.getSearchedList(boardId, searchKeyword);
            }
        } else {
            if (searchKeyword == null) {
                return postService.getPostList(boardId, page);
            } else {
                return postService.getSearchedList(boardId, page, searchKeyword);
            }
        }
    }

    @GetMapping("/detail")
    public PostDto detail(@RequestParam int id) {
        return postService.getPostDetail(id);
    }

    @PostMapping("/doModify")
    public void updatePost(PostForm form) {
        postService.updatePost(form);
    }

    @PostMapping("/write")
    public void createPost(PostForm form,HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("SESSION_ID");
        form.setUserId(user.getId());
        postService.createPost(form);
    }

    @DeleteMapping("/delete")
    public void deletePost(@RequestParam int id, HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("SESSION_ID");
        postService.deletePost(id ,req);
    }

}
