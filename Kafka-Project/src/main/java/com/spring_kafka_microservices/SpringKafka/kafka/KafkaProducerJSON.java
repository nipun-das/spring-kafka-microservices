package com.spring_kafka_microservices.SpringKafka.kafka;

import com.spring_kafka_microservices.SpringKafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerJSON {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducerJSON(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data){

        LOGGER.info(String.format("Message sent : %s", data.toString()));

        Message<User> message= MessageBuilder
                .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC,"messages")
                                .build();

        kafkaTemplate.send(message);
    }
}
