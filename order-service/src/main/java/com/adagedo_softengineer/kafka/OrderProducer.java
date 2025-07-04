package com.adagedo_softengineer.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
import org.springframework.messageing.support.MessageBuilder;
import com.adagedo_softengineer.dto.OrderEvent;
// this produce an event and send the event to the kafka broker
@Service
public class OrderProducer {

    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    private NewTopic topic;

    // this template is used to send a message to the kafka topic
    private KafkaTemplate<String, OrderEvent> template;

    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> template){
        this.topic = topic;
        this.template = template;
    }

    public void sendMessage(OrderEvent event) {
        logger.info(String.format("order event => %s", event.toString()));
        Message<OrderEvent> message = MessageBuilder.withPayload(event).setHeader(kafkaHeaders.TOPIC, topic.name()).build();
        template.send(message); // sends message to the topic 

    }
}
