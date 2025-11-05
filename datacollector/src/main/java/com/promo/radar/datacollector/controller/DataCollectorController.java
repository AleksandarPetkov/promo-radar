package com.promo.radar.datacollector.controller;

import com.promo.radar.datacollector.dto.Message;
import com.promo.radar.datacollector.service.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/datacollector")
public class DataCollectorController {

    private final PromotionService promotionService;

    public DataCollectorController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello From DataCollector Controller");
    }

    @PostMapping("/notifications")
    public ResponseEntity<Message> sendKafkaMessage(@RequestBody Message request) {
        return ResponseEntity.ok(promotionService.sendKafkaMessage(request));
    }

}