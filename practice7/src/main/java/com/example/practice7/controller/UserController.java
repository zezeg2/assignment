package com.example.practice7.controller;

import com.example.practice7.domain.user.User;
import com.example.practice7.domain.user.UserForm;
import com.example.practice7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/usr/member")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("/doLogin")
    public User doLogin(UserForm form, HttpServletRequest req){
        User user = userService.login(form, req);
        return user;
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest req){
        userService.logout(req);
    }

}
