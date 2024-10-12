package org.training.microservice.msorder.order.input;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;


public interface IOrderProcessRestController {


    @Operation(tags = "deneme",summary = "order place",description = "uzun uzun order place")
    OrderPlaceResponse placeOrder(@Valid @RequestBody OrderDto orderDtoParam);

    public void cancelOrder();

    public void activateOrder();
}
