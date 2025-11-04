package com.promo.radar.products.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {

    // The value is reading from the Config Server
//    @Value("${products.greeting.message}") // TODO Uncomment when complete docker conf
    private String greetingMessage;

    @GetMapping
    public ResponseEntity<String> hello() {
//        return ResponseEntity.ok(greetingMessage);
        return ResponseEntity.ok("Hello From Product Controller");
    }

}
