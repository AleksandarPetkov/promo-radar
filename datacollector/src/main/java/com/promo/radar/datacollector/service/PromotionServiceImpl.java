package com.promo.radar.datacollector.service;

import com.promo.radar.datacollector.dto.Event;
import com.promo.radar.datacollector.kafka.MessageProducer;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    private static Logger log = LoggerFactory.getLogger(PromotionServiceImpl.class);
    private final MessageProducer messageProducer;

    public PromotionServiceImpl(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @Override
    public Event processPromotion() {
        log.info("Start to process promotion...");
        Event event = new Event("1.0", "Test kafka connection..");

        messageProducer.sendMessage("products.created", event);

        return event;
    }
}
