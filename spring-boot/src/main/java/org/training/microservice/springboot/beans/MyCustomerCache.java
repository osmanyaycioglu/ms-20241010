package org.training.microservice.springboot.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.training.microservice.springboot.models.Customer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Lazy
@Component
public class MyCustomerCache {
    private Map<String/* username */, Customer> customerMap = new ConcurrentHashMap<>();

    public Customer getCustomer(String username){
        return customerMap.get(username);
    }
}
