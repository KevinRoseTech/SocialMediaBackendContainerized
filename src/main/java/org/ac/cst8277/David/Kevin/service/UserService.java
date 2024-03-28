package org.ac.cst8277.David.Kevin.service;

import org.ac.cst8277.David.Kevin.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<UserDto> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", userDtoRowMapper());
    }
    public boolean isAuthorized(String token) {
        // This is a placeholder implementation.
        return true;
    }
    private RowMapper<UserDto> userDtoRowMapper() {
        return (rs, rowNum) -> new UserDto(
                rs.getLong("userid"),
                rs.getBoolean("isproducer"),
                rs.getBoolean("issubscriber")
        );
    }
    public void addUser(UserDto user) {
        String sql = "INSERT INTO users (isproducer, issubscriber) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.isProducer(), user.isSubscriber());
    }
}
