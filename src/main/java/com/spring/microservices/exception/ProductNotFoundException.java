package com.spring.microservices.exception;


import lombok.Data;

@Data
public class ProductNotFoundException extends  RuntimeException{

    private final Integer errorCode;
    private final String errorMessage;
    private final String errorDescription;

    public ProductNotFoundException(Integer errorCode, String errorMessage, String errorDescription) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }
}
