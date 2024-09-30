package com.spring.microservices.controller;

import com.spring.microservices.model.OrderDTO;
import com.spring.microservices.model.Orders;
import com.spring.microservices.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public OrderDTO createOrder(@RequestBody OrderDTO order){
        return orderService.createOrder(order);
    }

    @GetMapping("/orders")
    public List<Orders> retrieveOrders(){
        return orderService.retrieveOrders();
    }

    @GetMapping("/order/{id}")
    public Orders retrieveOrder(@PathVariable  UUID id){
        return orderService.retrieveOrder(id);
    }

    @PatchMapping("/order/{id}")
    public Orders updateOrder(@RequestBody Orders order, @PathVariable UUID id){
        return orderService.updateOrder(order, id);
    }
}
