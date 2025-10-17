package com.promo.radar.users.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // The value is reading from the Config Server
    @Value("${user.greeting.message}")
    private String greetingMessage;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(greetingMessage);
    }

}
