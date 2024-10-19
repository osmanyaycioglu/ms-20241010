package org.training.microservice.msorder.integration.resliency.test;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

//@Component
@RequiredArgsConstructor
public class MyTestRunner implements CommandLineRunner {
    private final MyCalleeBean           myCalleeBean;
    private final RetryRegistry          retryRegistry;
    private final CircuitBreakerRegistry circuitBreakerRegistry;

    @Override
    public void run(final String... args) throws Exception {
        Retry retryLoc = retryRegistry.retry("retry-pay4");
        retryLoc.getEventPublisher()
                .onRetry(ec -> System.out.println("^+%^+%^+%^ RETRY : " + ec.toString()))
                .onSuccess(ec -> System.out.println("^+%^+%^+%^ SUCCESS : " + ec.toString()));
        for (int i = 0; i < 100; i++) {
            System.out.println("Calling pay4 : " + i);
            try {
                myCalleeBean.pay4("order" + i,
                                  UUID.randomUUID()
                                      .toString(),
                                  new BigDecimal(i));
            } catch (Exception exp) {
                System.err.println("Exp : " + exp.getClass()
                                                 .getName());
            }

            Retry.Metrics metricsLoc = retryLoc.getMetrics();
            System.out.println("++^+^+^+ Retry s : "
                               + metricsLoc.getNumberOfSuccessfulCallsWithoutRetryAttempt()
                               + " swr : "
                               + metricsLoc.getNumberOfSuccessfulCallsWithRetryAttempt()
                               + " fwr: "
                               + metricsLoc.getNumberOfFailedCallsWithRetryAttempt()
                               + " fwor : "
                               + metricsLoc.getNumberOfFailedCallsWithoutRetryAttempt());
        }
    }
}
