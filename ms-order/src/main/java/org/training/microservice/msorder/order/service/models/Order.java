package org.training.microservice.msorder.order.service.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long          customerId;
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
