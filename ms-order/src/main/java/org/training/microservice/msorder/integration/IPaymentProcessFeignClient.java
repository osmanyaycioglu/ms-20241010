package org.training.microservice.msorder.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.microservice.msorder.integration.models.PaymentRequest;
import org.training.microservice.msorder.integration.models.PaymentResponse;

@FeignClient(value = "PAYMENT",contextId = "1")
public interface IPaymentProcessFeignClient {

    @PostMapping("/api/v1/payment/process/pay")
    PaymentResponse pay(@RequestBody PaymentRequest paymentRequestParam);

}
