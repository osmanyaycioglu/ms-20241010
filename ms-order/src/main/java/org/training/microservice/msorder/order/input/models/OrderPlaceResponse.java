package org.training.microservice.msorder.order.input.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlaceResponse {
    private String        orderId;
    private String        orderRequestId;
    private Double        price;
    private ZonedDateTime estimation;
    private String        desc;
}
