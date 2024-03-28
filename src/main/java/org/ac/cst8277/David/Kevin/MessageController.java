package org.ac.cst8277.David.Kevin;

import org.ac.cst8277.David.Kevin.dto.MessageDto;
import org.ac.cst8277.David.Kevin.service.MessageService;
import org.ac.cst8277.David.Kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> postMessage(@RequestBody MessageDto message, @RequestHeader("Authorization") String token) {
        if (userService.isAuthorized(token)) {
            messageService.postMessage(message);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping("/producer/{producerId}")
    public ResponseEntity<List<MessageDto>> getMessagesByProducer(@PathVariable Long producerId) {
        List<MessageDto> messages = messageService.getMessagesByProducer(producerId);
        return ResponseEntity.ok(messages);
    }
    @GetMapping
    public ResponseEntity<List<MessageDto>> getAllMessages() {
        List<MessageDto> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }
    @GetMapping("/subscriber/{subscriberId}")
    public ResponseEntity<List<MessageDto>> getMessagesForSubscriber(@PathVariable Long subscriberId) {
        List<MessageDto> messages = messageService.getMessagesForSubscriber(subscriberId);
        return ResponseEntity.ok(messages);
    }
}
