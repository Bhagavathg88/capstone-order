package com.spring.microservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.spring.microservices.model.Orders;

@Service
@RequiredArgsConstructor
public class NotificationConsumerService {

    private final OrderService orderService;

    @KafkaListener(topics = "payment-events", groupId = "order-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);

        Orders order = orderService.retrieveOrder(UUID.fromString(message));
        order.setStatus("PAID");
        orderService.updateOrder(order);

    }

}
