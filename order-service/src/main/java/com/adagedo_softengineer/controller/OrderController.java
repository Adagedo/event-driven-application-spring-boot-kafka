package com.adagedo_softengineer.controller;

import java.util.UUID;

import org.hibernate.query.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adagedo_softengineer.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v3")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer){
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending...");
        orderEvent.setMessage("incoming pending order...");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "order is place successfully";
    }

}
// once this pc is change omo im comming for all th forbbiden knowlage in the world tech its just the matter of time and i know it nah just time i need
