package org.ac.cst8277.David.Kevin.service;

import org.ac.cst8277.David.Kevin.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void postMessage(MessageDto message) {
        String sql = "INSERT INTO messages (messagecontent, userid) VALUES (?, ?)";
        jdbcTemplate.update(sql, message.getMessageContent(), message.getUserId());
    }
    public List<MessageDto> getAllMessages() {
        String sql = "SELECT * FROM messages";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new MessageDto(
                rs.getLong("messageid"),
                rs.getString("messagecontent"),
                rs.getLong("userid")));
    }

    public List<MessageDto> getMessagesByProducer(Long producerId) {
        String sql = "SELECT * FROM messages WHERE userid = ?";
        return jdbcTemplate.query(sql, new Object[]{producerId}, (rs, rowNum) -> new MessageDto(
                rs.getLong("messageid"),
                rs.getString("messagecontent"),
                rs.getLong("userid")));
    }
    public List<MessageDto> getMessagesForSubscriber(Long subscriberId) {
        String sql = "SELECT m.* FROM messages m JOIN subscriptions s ON m.userid = s.producerid WHERE s.subscriberid = ?";
        return jdbcTemplate.query(sql, new Object[]{subscriberId}, (rs, rowNum) -> new MessageDto(
                rs.getLong("messageid"),
                rs.getString("messagecontent"),
                rs.getLong("userid")));
    }
}
