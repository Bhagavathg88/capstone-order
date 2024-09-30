package com.spring.microservices.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Inventory {

    private Long id;
    private Long productId;
    private Integer quantity;
    private Integer zipcode;
    private String inventoryName;
    private String inventoryCode;

    public Inventory( Long id, Long productId, Integer quantity, String inventoryName, String inventoryCode) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.inventoryName = inventoryName;
        this.inventoryCode = inventoryCode;
    }
}
