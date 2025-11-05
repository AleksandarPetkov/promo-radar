package com.promo.radar.datacollector.service;

import com.promo.radar.datacollector.dto.Event;
import com.promo.radar.datacollector.dto.Message;
import com.promo.radar.datacollector.kafka.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    private static Logger log = LoggerFactory.getLogger(PromotionServiceImpl.class);

    @Value("${topic.product.name}")
    private String topicName;

    private final MessageProducer messageProducer;

    public PromotionServiceImpl(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @Override
    public Event processPromotion() {
        log.info("Start to process promotion...");
        Event event = new Event("1.0", "Test kafka connection..");

        messageProducer.sendMessage(topicName, event);

        return event;
    }

    @Override
    public Message sendKafkaMessage(Message message) {
        log.info("New Kafka event arrived: {}", message);

        messageProducer.sendMessage(topicName, new Event(message.version(), message.description()));

        return message;
    }
}
