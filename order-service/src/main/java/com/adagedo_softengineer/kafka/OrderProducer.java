package com.adagedo_softengineer.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.adagedo_softengineer.dto.OrderEvent;
// this produce an event and send the event to the kafka broker
@Service
public class OrderProducer {

    private NewTopic topic;

    // this template is used to send a message to the kafka topic
    private KafkaTemplate<String, OrderEvent> template;
}
