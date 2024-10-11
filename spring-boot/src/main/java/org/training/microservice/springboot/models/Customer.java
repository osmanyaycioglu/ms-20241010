package org.training.microservice.springboot.models;

import lombok.Data;

@Data
public class Customer {
    private String username;
    private String name;
    private int counter;
    private Phone phone;

 }
