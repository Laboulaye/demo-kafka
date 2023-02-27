package com.study.demokafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic exampleTopic(){
        return TopicBuilder.name("string-topic")
                .build();
    }

    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("json-topic")
                .build();
    }
}
