package com.spring.microservices.model;

import lombok.Data;

@Data
public class CreditCard {

    private Long creditCardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String securityCode;
    private String cardType;
    private Integer zipCode;

}
