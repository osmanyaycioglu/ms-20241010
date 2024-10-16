package org.training.microservice.mspayment.input.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private String orderId;
    private String customerId;
    private BigDecimal amount;
}
