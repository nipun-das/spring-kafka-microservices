package com.spring_kafka_microservices.SpringKafka.controller;

import com.spring_kafka_microservices.SpringKafka.kafka.KafkaProducer;
import com.spring_kafka_microservices.SpringKafka.kafka.KafkaProducerJSON;
import com.spring_kafka_microservices.SpringKafka.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageControllerJSON {

    private KafkaProducerJSON kafkaProducerJSON;
    public MessageControllerJSON(KafkaProducerJSON kafkaProducerJSON) {
        this.kafkaProducerJSON = kafkaProducerJSON;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User data){
        kafkaProducerJSON.sendMessage(data);
        return ResponseEntity.ok("Message sent to the topic..");
    }
}
