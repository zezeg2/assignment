package com.example.practice7.service;

import com.example.practice7.domain.post.Post;
import com.example.practice7.domain.post.PostDto;
import com.example.practice7.domain.post.PostForm;
import com.example.practice7.domain.user.User;
import com.example.practice7.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getRecentPost(String type) {
        List<Post> result = null;
        if (type.equals("notice")){
            result = postRepository.findAllNotice(0);
        } else if(type.equals("free")) {
            result = postRepository.findAllFree(0);
        }
        return result;
    }
    public List<Post> getPostList(int boardId) {
        List<Post> result = null;
        if (boardId==1){
            result = postRepository.findAllNotice(0);
        } else if(boardId==2){
            result = postRepository.findAllFree(0);
        }
        return result;
    }
    public List<Post> getPostList(int boardId, int page) {
        List<Post> result = null;
        if (boardId==1){
            result = postRepository.findAllNotice(page);
        } else if(boardId==2){
            result = postRepository.findAllFree(page);
        }
        return result;
    }

    public List<Post> getSearchedList(int boardId, String searchKeyword) {
        List<Post> result = null;
        if (boardId==2) {
            result = postRepository.findByTitleNotice(searchKeyword, 0);
        }
        return result;
    }

    public List<Post> getSearchedList(int boardId, int page, String searchKeyword) {
        List<Post> result = null;
        if (boardId==1) {
            result = postRepository.findByTitleNotice(searchKeyword, page-1);
        } else if (boardId == 2){
            result = postRepository.findByTitleFree(searchKeyword, page-1);
        }
        return result;
    }



    public PostDto getPostDetail(int id) {
        return postRepository.findById(id).get().toDto();
    }

    public void updatePost(PostForm form) {
        Post post = postRepository.findById(form.getId()).get();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        postRepository.update(post);
    }

    public void createPost(PostForm form) {
        Post post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setNotice(form.isNotice());
        post.setUserId(form.getUserId());

        postRepository.create(post);
    }

    public void deletePost(int id, HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("SESSION_ID");
        if (user.isAdmin()) {
            postRepository.deleteById(id);
        } else{
            if (user.getId() == postRepository.findById(id).get().getUserId()){
                postRepository.deleteById(id);
            }
        }
    }
}
