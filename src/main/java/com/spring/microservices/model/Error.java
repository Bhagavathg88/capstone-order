package com.spring.microservices.model;

import lombok.Data;

@Data
public class Error {
    private Integer errorCode;
    private String errorMessage;
    private String errorDescription;

}
