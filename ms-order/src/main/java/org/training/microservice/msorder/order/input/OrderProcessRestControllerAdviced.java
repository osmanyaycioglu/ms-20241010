package org.training.microservice.msorder.order.input;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/process")
public class OrderProcessRestControllerAdviced {

    @PutMapping("/place")
    public void placeOrder(){
    }

    public void cancelOrder(){
    }

    public void activateOrder(){
    }
}
