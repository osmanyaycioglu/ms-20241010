package org.training.microservice.msorder.order.input;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;
import org.training.microservice.msorder.order.input.models.Response;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @PostMapping(value = "/place", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderPlaceResponse insertOrder(@RequestBody OrderDto orderDtoParam) {
        return new OrderPlaceResponse();
    }

    public void deleteOrder() {
    }


}
