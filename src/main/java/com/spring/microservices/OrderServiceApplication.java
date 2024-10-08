package com.spring.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class OrderServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
