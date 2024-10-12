package org.training.microservice.msorder.order.input.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.training.microservice.msorder.validation.CheckWords;

import java.util.List;

@Data
@CheckWords(words = {"abc","xyz","123"})
public class OrderDto {
    @NotBlank
    private String customerName;
    private String customerSurname;
    private String phoneNumber;
    @NotBlank
    @Size(min = 10,max = 10)
    private String orderRequestId;
    @NotNull
    @Size(min = 1,max = 20)
    @Valid
    private List<Meal> meals;
}
