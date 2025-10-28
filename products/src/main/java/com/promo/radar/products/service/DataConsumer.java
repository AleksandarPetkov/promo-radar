package com.promo.radar.products.service;

import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DataConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(DataConsumer.class);

    @KafkaListener(topics = "products.created", groupId = "my-group-id")
    public void listen(GenericRecord message) {
        LOG.info("Received message: {}", message);
    }
}
