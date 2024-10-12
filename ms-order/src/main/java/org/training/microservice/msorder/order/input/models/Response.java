package org.training.microservice.msorder.order.input.models;

public class Response<T> {
    private boolean errorOccurred;
    private String errorDesc;
    private Integer code;
    private T response;

}
