package com.example.practice7.service;

import com.example.practice7.domain.user.User;
import com.example.practice7.domain.user.UserForm;
import com.example.practice7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User login(UserForm form, HttpServletRequest req) {
        Optional<User> user = userRepository.findByUsername(form.getUsername());
        if (user.isEmpty()){
            return null;
        }
        if (user.get().getPassword().equals(form.getPassword())){
            HttpSession session = req.getSession(true);
            session.setAttribute("SESSION_ID", user.get());
            return user.get();
        }
        return null;
    }

    public void logout(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 제거
        }
    }
}
