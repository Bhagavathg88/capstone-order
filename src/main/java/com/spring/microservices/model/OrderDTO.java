package com.spring.microservices.model;

import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {

    public String userID;
    public List<Product> products;
    public Instant OrderDate;
    public String status;
    public UUID orderKey;
    public Integer zipcode;
    public Payment payment;
}
