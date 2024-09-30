package com.spring.microservices.model;

import lombok.Data;

@Data
public class ACHDetails {

    private Long accountNumber;
    private Long routingNumber;
    private Integer zipCode;

}
