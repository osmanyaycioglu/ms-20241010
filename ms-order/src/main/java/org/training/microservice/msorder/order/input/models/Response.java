package org.training.microservice.msorder.order.input.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private boolean errorOccurred;
    private String  errorDesc;
    private Integer code;
    private T       response;

    public static <T> Response<T> createSuccessResponse(T resp) {
        return new Response<>(false,
                              null,
                              null,
                              resp);
    }

}
