package com.promo.radar.datacollector.kafka;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private static final Logger LOG = LoggerFactory.getLogger(MessageProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object object) {
        if (StringUtils.isBlank(topic)) {
            LOG.warn("Skipping message send: topic is null or empty");
            return;
        }

        kafkaTemplate.send(topic, object).whenComplete((result, ex) -> {
            if (ex == null) {
                LOG.info("Sent message [{}] to topic [{}] with offset [{}]",
                        object, result.getRecordMetadata().topic(), result.getRecordMetadata().offset());
            } else {
                LOG.error("Failed to send message [{}] due to {}", object, ex.getMessage(), ex);
            }
        });
    }
}