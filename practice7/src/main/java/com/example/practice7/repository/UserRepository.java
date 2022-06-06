package com.example.practice7.repository;

import com.example.practice7.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}
