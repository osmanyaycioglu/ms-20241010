package org.training.microservice.msorder.order.service.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.training.microservice.msorder.validation.CheckWords;

@Getter
@Setter
@Entity
public class Meal {
    @Id
    @GeneratedValue
    private Long mId;
    private String name;
    private String mealId;
    private Double portion;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Order order;
}
