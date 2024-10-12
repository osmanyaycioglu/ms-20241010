package org.training.microservice.mscommon.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @Value("${spring.application.name}")
    private String microserviceName;

    @Value("${bounded.context.name}")
    private String boundedContextName;



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleExp(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDesc(exp.getMessage())
                       .withErrorCode(1024)
                .withBoundedContext(boundedContextName)
                .withMicroservice(microserviceName)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleExp(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withBoundedContext(boundedContextName)
                       .withMicroservice(microserviceName)
                       .withErrorDesc("validation error")
                       .withErrorCode(1025)
                       .withSubErrors(getCollectedErrors(exp))
                       .build();

    }

    private List<ErrorObj> getCollectedErrors(final MethodArgumentNotValidException exp) {
        return exp.getAllErrors()
                  .stream()
                  .peek(seo -> System.out.println("ErrorClass : " + seo.getClass()))
                  .map(seo -> ErrorObj.builder()
                                      .withBoundedContext(boundedContextName)
                                      .withMicroservice(microserviceName)
                                      .withErrorDesc(exp.toString())
                                      .withErrorCode(1026)
                                      .build())
                  .collect(Collectors.toList());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleExp(Exception exp) {
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                                 .body(ErrorObj.builder()
                                               .withBoundedContext(boundedContextName)
                                               .withMicroservice(microserviceName)
                                               .withErrorDesc(exp.getMessage())
                                               .withErrorCode(5001)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder()
                                           .withBoundedContext(boundedContextName)
                                           .withMicroservice(microserviceName)
                                           .withErrorDesc(exp.getMessage())
                                           .withErrorCode(5000)
                                           .build());

    }

}
