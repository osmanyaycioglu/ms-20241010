package org.training.microservice.msorder.order.input;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.msorder.order.input.models.OrderDto;
import org.training.microservice.msorder.order.input.models.OrderPlaceResponse;
import org.training.microservice.msorder.order.input.models.Response;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping(value = "/place", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderPlaceResponse insertOrder(@RequestBody OrderDto orderDtoParam) {
        return new OrderPlaceResponse();
    }

    @PreAuthorize("hasAnyAuthority('VIWER')")
    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("orderId") String orderId) {
        return "OK";
    }


}
