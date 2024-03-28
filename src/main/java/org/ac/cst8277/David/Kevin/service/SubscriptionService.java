package org.ac.cst8277.David.Kevin.service;

import org.ac.cst8277.David.Kevin.dto.SubscriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addSubscription(SubscriptionDto subscription) {
        String sql = "INSERT INTO user_subscriptions (subscriptionid, userid) VALUES (?, ?)";
        jdbcTemplate.update(sql, subscription.getSubscriptionId(), subscription.getSubscriberId());
    }
}
