package com.revature.controllers;

import com.revature.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kps;

    @PostMapping("publish")
    public void sendMsgToKafkaTopic(@RequestParam("message") String message){
        //http:localhost:8080/kafka/publish?message=hello

        System.out.println("Incoming HTTP Request Message: " + message);
        kps.sendMessage(message);
    }

}
