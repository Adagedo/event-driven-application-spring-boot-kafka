package com.adagedo_softengineer.kafka;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import com.adagedo_softengineer.dto.OrderEvent;



@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}", 
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event) {
        
        logger.info(String.format("order recieved in the stock service => %s", event.toString()));

        // you can save the order event data into the database
    }

}
