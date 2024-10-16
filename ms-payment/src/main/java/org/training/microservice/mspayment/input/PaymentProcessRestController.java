package org.training.microservice.mspayment.input;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.HeaderParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.mscommon.error.ErrorObj;
import org.training.microservice.mspayment.common.PaymentException;
import org.training.microservice.mspayment.input.models.PaymentRequest;
import org.training.microservice.mspayment.input.models.PaymentResponse;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payment/process")
public class PaymentProcessRestController {

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/pay")
    public PaymentResponse pay(@RequestBody PaymentRequest paymentRequestParam) {
        return new PaymentResponse(UUID.randomUUID()
                                       .toString(),
                                   "response port : " + port);
    }

//    @PostMapping("/{command}")
//    public ResponseEntity<?> dynamicMethod(@PathVariable("command") String command,
//                                           HttpServletRequest requestParam) {
//        switch (command) {
//            case "pay":
//
//        }
//    }

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleExp(PaymentException exp) {
        return ErrorObj.builder()
                       .withErrorDesc(exp.getDesc())
                       .withErrorCode(exp.getErrorCause())
                       .withBoundedContext("orderBoundedContext")
                       .withMicroservice("payment")
                       .build();
    }


}
