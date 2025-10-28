package com.promo.radar.datacollector.kafka;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

    @Value("${topic.product.name}")
    private String topicName;
    @Value("${topic.product.partitions}")
    private int partitions;
    @Value("${topic.product.replicas}")
    private int replicas;

    /**
     * Sends messages to Kafka using a single, shared {@link KafkaTemplate}.
     * This approach allows sending records to multiple topics dynamically by specifying the
     * topic at runtime. By reusing the same template:
     *
     *  - Reduces memory and thread usage since only one producer instance is maintained.
     *  - Maximizes batching, compression, and network efficiency across topics.
     *  - Simplifies configuration and maintenance compared to creating multiple templates.
     *
     * Note: If per-topic producer configurations (e.g., retries, serializers) are required,
     * multiple KafkaTemplates may be necessary. Otherwise, this approach is preferred for
     * performance, scalability, and maintainability in microservices.
     */
    @Bean
    public KafkaTemplate<String, GenericRecord> kafkaTemplate(ProducerFactory<String, GenericRecord> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public NewTopic productCreatedTopic() {
        return TopicBuilder.name(topicName)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }

}