package com.spring.microservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private List<Inventory> stocks;
    private Integer quantity;

}
