package org.training.microservice.mspayment.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentException extends RuntimeException {
    private String desc;
    private Integer errorCause;
}
