package com.promo.radar.promotions.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

    // The value is reading from the Config Server
    @Value("${promotions.greeting.message}")
    private String greetingMessage;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(greetingMessage);
    }

}
