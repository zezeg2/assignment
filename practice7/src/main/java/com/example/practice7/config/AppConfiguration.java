package com.example.practice7.config;

import com.example.practice7.repository.JdbcPostRepository;
import com.example.practice7.repository.JdbcUserRepository;
import com.example.practice7.repository.PostRepository;
import com.example.practice7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    private final DataSource dataSource;

    @Bean
    public UserRepository userRepository() {
        return new JdbcUserRepository(dataSource);
    }

    @Bean
    public PostRepository postRepository() {
        return new JdbcPostRepository(dataSource);
    }
}
