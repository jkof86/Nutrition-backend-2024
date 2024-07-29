package com.revature.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    //subscribes to "Test" topic

    @KafkaListener(topics = "Test")
    public void consume(String message){
        System.out.println("Message Received: " + message);
    }
}
