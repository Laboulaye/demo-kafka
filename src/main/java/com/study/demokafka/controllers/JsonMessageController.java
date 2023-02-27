package com.study.demokafka.controllers;

import com.study.demokafka.payload.User;
import com.study.demokafka.service.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    @Autowired
    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.send(user);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }
}
