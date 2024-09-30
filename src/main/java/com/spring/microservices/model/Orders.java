package com.spring.microservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private UUID orderKey;
    private Long productId;
    private String userID;
    private Instant orderDate;
    private String productName;
    private Double price;
    private String status;
    private Integer quantity;
    private Double orderTotal;
    private Integer zipcode;
    private Long inventoryId;

}


