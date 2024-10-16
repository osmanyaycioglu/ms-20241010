package org.training.microservice.msorder.order.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearch {
    private String        orderId;
    private Long          customerId;
}
