package com.osipov.rabbitmq.controller;

import com.osipov.rabbitmq.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final MessageSender messageSender;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        if (message.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        messageSender.send(message);
        return ResponseEntity.ok().build();
    }
}
