package org.training.microservice.msorder.integration;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyResponseListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "notify-response-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-response-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "notify-response"
    )
    )
    public void handleSmsEvent(String stringParam) {
        System.out.println("I got Notify Response : " + stringParam);
    }


}
