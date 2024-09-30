package com.spring.microservices.model;

import lombok.Data;

@Data
public class DebitCard {

    private Long debitCardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String securityCode;
    private String cardType;
    private Integer zipCode;
}
