package org.training.microservice.msorder.order.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateReturn {
    private String        orderId;
    private String        orderRequestId;
    private BigDecimal    price;
    private ZonedDateTime estimation;
    private String        desc;
}
