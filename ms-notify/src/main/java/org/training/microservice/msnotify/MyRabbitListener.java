package org.training.microservice.msnotify;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(queues = "deneme")
    public void handleDenemeEvent(String stringParam) {
    }

}
