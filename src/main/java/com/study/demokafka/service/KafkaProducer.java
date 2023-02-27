package com.study.demokafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private KafkaTemplate<String, String> kafkaTemplate;

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        LOGGER.info(String.format("Message sent: %s", message));
        kafkaTemplate.send("string-topic", message);
    }
}
