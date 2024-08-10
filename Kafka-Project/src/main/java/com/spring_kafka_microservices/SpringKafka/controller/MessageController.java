package com.spring_kafka_microservices.SpringKafka.controller;

import com.spring_kafka_microservices.SpringKafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String msg){
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message sent to the topic..");
    }
}
