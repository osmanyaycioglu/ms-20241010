package org.training.microservice.msorder.order.input;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.msorder.order.input.mappers.IOrderMapper;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;
import org.training.microservice.msorder.order.service.OrderProcessService;


@RestController
@RequestMapping("/api/v1/order/process")
@RequiredArgsConstructor
public class OrderProcessRestController implements IOrderProcessRestController {
    private final OrderProcessService orderProcessService;


    @PostMapping("/place1")
    @Override
    public OrderPlaceResponse placeOrder(OrderDto orderDtoParam) {
        return IOrderMapper.ORDER_MAPPER.toOrderPlaceResponse(orderProcessService.place(IOrderMapper.ORDER_MAPPER.toOrder(orderDtoParam)));
    }

    @PostMapping("/place2")
    public OrderPlaceResponse placeOrder2(OrderDto orderDtoParam) {
        return IOrderMapper.ORDER_MAPPER.toOrderPlaceResponse(orderProcessService.place2(IOrderMapper.ORDER_MAPPER.toOrder(orderDtoParam)));
    }

    @PostMapping("/place3")
    public OrderPlaceResponse placeOrder3(OrderDto orderDtoParam) {
        return IOrderMapper.ORDER_MAPPER.toOrderPlaceResponse(orderProcessService.place3(IOrderMapper.ORDER_MAPPER.toOrder(orderDtoParam)));
    }

    @PostMapping("/place4")
    public OrderPlaceResponse placeOrder4(OrderDto orderDtoParam) {
        return IOrderMapper.ORDER_MAPPER.toOrderPlaceResponse(orderProcessService.place4(IOrderMapper.ORDER_MAPPER.toOrder(orderDtoParam)));
    }

    public void cancelOrder() {
    }

    public void activateOrder() {
    }

}
