package org.training.microservice.msorder.order.service.models;

import lombok.Data;
import org.training.microservice.msorder.validation.CheckWords;

@Data
public class Meal {
    private String name;
    private String mealId;
    private Double portion;
}
