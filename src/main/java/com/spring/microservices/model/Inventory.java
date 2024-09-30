package com.spring.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
