package org.training.microservice.msorder.order.input;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;


@RestController
@RequestMapping("/api/v1/order/process")
public class OrderProcessRestController implements IOrderProcessRestController {

    @PostMapping("/place")
    @Override
    public OrderPlaceResponse placeOrder(OrderDto orderDtoParam){
        return null;
    }

    public void cancelOrder(){
    }

    public void activateOrder(){
    }

}
