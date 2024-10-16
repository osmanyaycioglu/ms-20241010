package org.training.microservice.msorder.integration;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.training.microservice.msorder.integration.models.PaymentRequest;
import org.training.microservice.msorder.integration.models.PaymentResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class PaymentProcessIntegration {
    private final RestTemplate               restTemplate;
    private final RestClient                 restClient;
    private final EurekaClient               eurekaClient;
    private final IPaymentProcessFeignClient paymentProcessFeignClient;
    private       AtomicLong                 index = new AtomicLong();

    public PaymentResponse pay(String orderId,
                               String customerId,
                               BigDecimal amount) {
        PaymentRequest paymentRequestLoc = PaymentRequest.builder()
                                                         .withOrderIdParam(orderId)
                                                         .withCustomerIdParam(customerId)
                                                         .withAmountParam(amount)
                                                         .build();
        return restTemplate.postForObject("http://PAYMENT/api/v1/payment/process/pay",
                                          paymentRequestLoc,
                                          PaymentResponse.class);
    }

    public PaymentResponse pay2(String orderId,
                                String customerId,
                                BigDecimal amount) {
        PaymentRequest paymentRequestLoc = PaymentRequest.builder()
                                                         .withOrderIdParam(orderId)
                                                         .withCustomerIdParam(customerId)
                                                         .withAmountParam(amount)
                                                         .build();
        ResponseEntity<PaymentResponse> paymentResponseLoc = restClient.post()
                                                                       .uri("http://PAYMENT/api/v1/payment/process/pay")
                                                                       .contentType(MediaType.APPLICATION_JSON)
                                                                       .body(paymentRequestLoc)
                                                                       .retrieve()
                                                                       .toEntity(PaymentResponse.class);
        return paymentResponseLoc.getBody();

    }

    public PaymentResponse pay3(String orderId,
                                String customerId,
                                BigDecimal amount) {
        PaymentRequest paymentRequestLoc = PaymentRequest.builder()
                                                         .withOrderIdParam(orderId)
                                                         .withCustomerIdParam(customerId)
                                                         .withAmountParam(amount)
                                                         .build();
        List<InstanceInfo> instancesLoc = eurekaClient.getApplication("PAYMENT")
                                                      .getInstances();
        InstanceInfo instanceInfoLoc = instancesLoc.get((int) (index.incrementAndGet() % instancesLoc.size()));
        RestTemplate restTemplateLoc = new RestTemplate();
        return restTemplateLoc.postForObject("http://"
                                          + instanceInfoLoc.getIPAddr()
                                          + ":"
                                          + instanceInfoLoc.getPort()
                                          + "/api/v1/payment/process/pay",
                                          paymentRequestLoc,
                                          PaymentResponse.class);
    }

    public PaymentResponse pay4(String orderId,
                                String customerId,
                                BigDecimal amount) {
        PaymentRequest paymentRequestLoc = PaymentRequest.builder()
                                                         .withOrderIdParam(orderId)
                                                         .withCustomerIdParam(customerId)
                                                         .withAmountParam(amount)
                                                         .build();

        return paymentProcessFeignClient.pay(paymentRequestLoc);
    }

}
