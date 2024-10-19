package org.training.microservice.msorder.integration.resliency;

import org.training.microservice.msorder.integration.models.PaymentResponse;

import java.util.function.Predicate;

public class CheckPaymentResponse implements Predicate<PaymentResponse> {
    @Override
    public boolean test(final PaymentResponse paymentResponseParam) {
        if (paymentResponseParam.getPaymentId() == null) {
            return true;
        }
        return false;
    }
}
