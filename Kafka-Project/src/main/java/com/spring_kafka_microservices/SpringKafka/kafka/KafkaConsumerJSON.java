package com.spring_kafka_microservices.SpringKafka.kafka;

import com.spring_kafka_microservices.SpringKafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerJSON {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerJSON.class);


    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        LOGGER.info(String.format("Json message received - %s", user.toString()));
    }
}
