package org.training.microservice.msorder.order.input.models;

import lombok.Data;
import org.training.microservice.msorder.validation.CheckWords;

@Data
public class MealDto {
    @CheckWords(words = {"abc", "xyz", "123"})
    private String name;
    private String mealId;
    private Double portion;
}
