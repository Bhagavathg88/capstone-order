package com.spring.microservices.model;

import lombok.Data;

@Data
public class Payment {

    public String paymentMethod;
    public CreditCard creditCard;
    public ACHDetails achDetails;
    public DebitCard debitCard;
    public Double orderTotal;
    private Long orderId;
    private String userId;

}
