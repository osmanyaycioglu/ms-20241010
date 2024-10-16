package org.training.microservice.msorder.order.service.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long          customerId;
    private String        orderId;
    private String        customerName;
    private String        customerSurname;
    private String        phoneNumber;
    private String        orderRequestId;
    private EOrderStatus  orderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime estimation;
    private BigDecimal    price;
    private List<Meal>    meals;
}
