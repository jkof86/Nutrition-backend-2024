package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    //send message to kafka topic
    //a collection of events
    //we add a KafkaTemplate

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //we make a method to send message to our kafka topic
    public void sendMessage(String message) {
        System.out.println("Message Sent: " + message);
        kafkaTemplate.send("Test", message);

        //this template sends message to broker on topic "test"
        //anyone listening on "test topic will perform some action/logic
    }
}
