package com.spring_kafka_microservices.SpringKafka.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
