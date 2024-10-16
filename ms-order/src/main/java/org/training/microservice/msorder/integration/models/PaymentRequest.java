package org.training.microservice.msorder.integration.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PaymentRequest {
    private String     orderId;
    private String     customerId;
    private BigDecimal amount;

    @Builder(setterPrefix = "with")
    public PaymentRequest(final String orderIdParam,
                          final String customerIdParam,
                          final BigDecimal amountParam) {
        orderId    = orderIdParam;
        customerId = customerIdParam;
        amount     = amountParam;
    }
}
