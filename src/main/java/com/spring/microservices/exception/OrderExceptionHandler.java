package com.spring.microservices.exception;

import com.spring.microservices.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Error> handleProductNotFoundException(ProductNotFoundException ex){

        Error error = new Error();
        error.setErrorCode(ex.getErrorCode());
        error.setErrorMessage(ex.getErrorMessage());
        error.setErrorDescription(ex.getErrorDescription());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }


}
