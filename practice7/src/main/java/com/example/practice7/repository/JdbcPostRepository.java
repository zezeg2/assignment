package com.example.practice7.repository;

import com.example.practice7.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcPostRepository implements PostRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPostRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Post> postRowMapper() {
        return (rs, rowNum) -> {  // replace with lambda
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            post.setCreatedAt(LocalDateTime.parse(rs.getString("created_at"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            post.setUpdatedAt(LocalDateTime.parse(rs.getString("updated_at"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            post.setNotice(rs.getBoolean("is_notice"));
            post.setUserId(rs.getInt("user_id"));
            return post;
        };
    }

    @Override
    public Post create(Post post) {
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("post").usingGeneratedKeyColumns("id");
//        Map<String, Object> params = new HashMap<>();
//
//        params.put("title", post.getTitle());
//        params.put("content", post.getContent());
//        params.put("created_at", LocalDateTime.now());
//        params.put("updated_at", LocalDateTime.now());
//        params.put("is_notice", post.isNotice());
//        params.put("user_id", post.getUserId());
//
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));
//        post.setId(key.intValue());
//        return post;

        String sql = "insert into post (title, content, created_at, updated_at, is_notice, user_id) value (?,?,?,?,?,?)";
        int key = jdbcTemplate.update(sql
                , post.getTitle()
                , post.getContent()
                , LocalDateTime.now()
                , LocalDateTime.now()
                , post.isNotice()
                , post.getUserId()
        );

        post.setId(key);
        return post;
    }

    @Override
    public void update(Post post) {
        String sql = "update post set title=?, content=?,updated_at=? where id=?";
        jdbcTemplate.update(sql, post.getContent(), post.getTitle(), LocalDateTime.now(), post.getId());
    }

    @Override
    public Optional<Post> findById(int id) {
        String sql = "select * from post where id = ?";
        List<Post> result = jdbcTemplate.query(sql, postRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public List<Post> findAllFree(int page) {
        String sql = "select * from post where is_notice=false limit 10 offset ?";
        List<Post> result = jdbcTemplate.query(sql, postRowMapper(), page * 10);
        return result;
    }

    @Override
    public List<Post> findAllNotice(int page) {
        String sql = "select * from post where is_notice=true limit 10 offset ?";
        List<Post> result = jdbcTemplate.query(sql, postRowMapper(), page * 10);
        return result;
    }

    @Override
    public List<Post> findByTitleFree(String title, int page) {
        String sql = "select * from post where title like ? and is_notice=false limit 10 offset ?";
        List<Post> result = jdbcTemplate.query(sql, postRowMapper(), "%" + title + "%", page * 10);
        return result;
    }

    @Override
    public List<Post> findByTitleNotice(String title, int page) {
        String sql = "select * from post where title like ? and is_notice=true limit 10 offset ?";
        List<Post> result = jdbcTemplate.query(sql, postRowMapper(), "%" + title + "%", page * 10);
        return result;
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from post where id=?";
        jdbcTemplate.query(sql, postRowMapper());
    }
}
