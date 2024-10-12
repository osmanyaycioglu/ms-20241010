package org.training.microservice.msorder.order.input.models;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class OrderPlaceResponse {
    private String        orderId;
    private String        orderRequestId;
    private Double        price;
    private ZonedDateTime estimation;
}
