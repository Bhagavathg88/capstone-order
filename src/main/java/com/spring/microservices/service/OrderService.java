package com.spring.microservices.service;

import com.spring.microservices.exception.ProductNotFoundException;
import com.spring.microservices.model.*;
import com.spring.microservices.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProxyService proxyService;

    public OrderDTO createOrder(OrderDTO order){
        List<Orders> ordersList = mapOrderDtoToOrders(order)
                .orElseThrow(() -> new ProductNotFoundException(400,"Product not found", "Product not found in inventory"));
        ordersList =  orderRepository.saveAll(ordersList);

        return convertListToOrderDTO(ordersList);
    }

    public List<Orders> retrieveOrders(){
        return orderRepository.findAll();
    }

    public Orders retrieveOrder(UUID orderKey){
        return orderRepository.findByOrderKey(orderKey);
    }

    public Orders updateOrder(Orders order, UUID id){
        Orders availableOrder = retrieveOrder(id);
        availableOrder.setStatus(Optional.ofNullable(order.getStatus()).orElse(availableOrder.getStatus()));
        return orderRepository.save(availableOrder);
    }

    public Optional<List<Orders>> mapOrderDtoToOrders(OrderDTO order) {
        UUID randomId = UUID.randomUUID();
        AtomicReference<Double> orderTotal = new AtomicReference<>(0.0);
        List<Orders> ordersList = order.getProducts().stream().map(product -> {
            ProductResponse product1 = proxyService.getProductByZipcode(product.getId(), order.getZipcode());
            if(product1 == null){
                return null;
            }
            Orders orders = new Orders();
            orders.setUserID(order.getUserID());
            orders.setOrderKey(randomId);
            orders.setQuantity(product.getQuantity());
            orders.setInventoryId(product1.getStocks().get(0).getId());
            orders.setProductId(product.getId());
            orders.setOrderDate(Instant.now());
            orders.setPrice(product1.getPrice());
            orders.setProductName(product1.getName());
            orders.setStatus("PLACED");
            orders.setZipcode(order.getZipcode());
            orderTotal.updateAndGet(v -> v + product1.getPrice() * product.getQuantity());
            proxyService.updateInventory(new Inventory(orders.getInventoryId(), product1.getId(), orders.getQuantity(), "", ""),
                    orders.getInventoryId(),orders.getZipcode() );
            return orders;
        }).collect(Collectors.toList());

        Double orderPrice = orderTotal.get();
        if(ordersList.contains(null)){
            return Optional.empty();
        }
        return Optional.of(ordersList);
    }

    public OrderDTO convertListToOrderDTO(List<Orders> ordersList){
        OrderDTO orderDTO = new OrderDTO();
        List<Product> products = ordersList.stream().map(orders -> {
            Product product = new Product();
            product.setId(orders.getProductId());
            product.setName(orders.getProductName());
            product.setPrice(orders.getPrice());
            return product;
        }).collect(Collectors.toList());
        orderDTO.setProducts(products);
        orderDTO.setUserID(ordersList.get(0).getUserID());
        orderDTO.setOrderDate(ordersList.get(0).getOrderDate());
        orderDTO.setStatus(ordersList.get(0).getStatus());
        orderDTO.setOrderKey(ordersList.get(0).getOrderKey());
        return orderDTO;
    }

}

