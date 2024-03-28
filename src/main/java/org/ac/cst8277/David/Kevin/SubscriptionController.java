package org.ac.cst8277.David.Kevin;

import org.ac.cst8277.David.Kevin.dto.SubscriptionDto;
import org.ac.cst8277.David.Kevin.service.SubscriptionService;
import org.ac.cst8277.David.Kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;
    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestBody SubscriptionDto subscription, @RequestHeader("Authorization") String token) {
        if (userService.isAuthorized(token)) {
            subscriptionService.addSubscription(subscription);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
