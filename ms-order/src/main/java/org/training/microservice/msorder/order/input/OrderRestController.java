package org.training.microservice.msorder.order.input;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;
import org.training.microservice.msorder.order.input.models.Response;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @PostMapping("/place")
    public Response<OrderPlaceResponse> insertOrder(OrderDto orderDtoParam){
        return null;
    }

    public void deleteOrder(){
    }


}
