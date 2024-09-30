package com.spring.microservices.service;

import com.spring.microservices.model.Inventory;
import com.spring.microservices.model.Product;
import com.spring.microservices.model.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ProxyService {

    private RestTemplate restTemplate;

    ProxyService(){
        restTemplate = new RestTemplate();
    }

    public Product getProduct(Long id){
        return restTemplate.getForObject("http://localhost:8090/product/"+id, Product.class);
    }

    public ProductResponse getProductByZipcode(Long id, Integer zipcode){

        return restTemplate.getForObject("http://localhost:8090/product/"+id+"/"+zipcode, ProductResponse.class);
    }

    public void updateInventory(Inventory inventory, Long id, Integer zipcode){
        HttpEntity<Inventory> request = new HttpEntity<>(inventory);
        restTemplate.exchange("http://localhost:8092/inventory/"+id+"/"+zipcode, HttpMethod.POST, request,Inventory.class);

    }

}
