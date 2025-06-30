package com.adagedo_softengineer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// the kafka topic configuration
@Configuration
public class KafkaConfiguration {

    // grap the topic name from the application.yml config file
    @Value("${spring.kafka.topic.name}")
    private String topic_name;

    // bean for kafka topic 
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(topic_name).build();
    }
}
