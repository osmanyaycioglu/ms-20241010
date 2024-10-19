package org.training.microservice.msorder.integration.resliency.test;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.training.microservice.msorder.integration.models.PaymentResponse;

import java.math.BigDecimal;
import java.util.UUID;

// @Component
public class MyCalleeBean {

    private int counter = 0;

    @Retry(name = "retry-pay4")
    // @CircuitBreaker(name = "cb-pay4")
    public PaymentResponse pay4(String orderId,
                                String customerId,
                                BigDecimal amount) {
        counter++;
        System.out.println("Counter : " + counter);
        if (counter % 3 == 0) {
            System.out.println("Before exception : " + counter);
            throw new IllegalStateException();
        }
        return new PaymentResponse(UUID.randomUUID()
                                       .toString(),
                                   "oid : " + orderId);
    }


}
