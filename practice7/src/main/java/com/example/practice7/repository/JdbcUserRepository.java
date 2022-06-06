package com.example.practice7.repository;

import com.example.practice7.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {  // replace with lambda
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAdmin(rs.getBoolean("is_admin"));
            return user;
        };
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "select * from user where username = ?";
        List<User> result =  jdbcTemplate.query(sql, userRowMapper(), username);
        return result.stream().findAny();
    }
}
