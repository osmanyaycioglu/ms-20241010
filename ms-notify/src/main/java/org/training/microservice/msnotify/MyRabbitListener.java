package org.training.microservice.msnotify;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyRabbitListener {

    @Value("${server.port}")
    private Integer port;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "sms-notify-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "sms-notify"
    )
    )
    public void handleSmsEvent(String stringParam) {
        System.out.println("I got SMS : " + stringParam);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "email-notify-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "email-notify"
    )
    )
    public void handleEmailEvent(String stringParam) {
        System.out.println("I got Email : " + stringParam);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "mms-notify-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "mms-notify"
    )
    )
    public void handleMMSEvent(String stringParam) {
        System.out.println("I got MMS : " + stringParam);
    }

    // message.adv.eu.tr.sms.adana
    // notification.alarm.eu.tr.mms.istanbul
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "message-topic-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "message.#"
    )
    )
    public void handleAllMessages(NotifyMessage stringParam) {
        System.out.println("I got MESSAGE : " + stringParam);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "notification-topic-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "notification.#"
    )
    )
    @SendTo("notify-response-exchange/notify-response")
    public String handleAllNotifications(NotifyMessage stringParam) {
        System.out.println("I got NOTIFICATION : " + stringParam);
        return "Sent notification to : " + stringParam.getDestination();
    }

//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "all-topic-q", durable = "true", autoDelete = "false"),
//            exchange = @Exchange(value = "notify-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
//            key = "#"
//    )
//    )
//    public void handleAll(Message message) throws IOException {
//        System.out.println("******************************........................." + message);
//        ObjectMapper objectMapperLoc = new ObjectMapper();
//        NotifyMessage notifyMessageLoc = objectMapperLoc.readValue(message.getBody(),
//                                                                   NotifyMessage.class);
//        System.out.println("I got ALL : " + notifyMessageLoc);
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "tr-sms-topic-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(value = "notify-topic-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "message.*.*.tr.sms.#"
    )
    )
    public void handleTRSms(NotifyMessage stringParam) {
        System.out.println("I got TR SMS : " + stringParam);
    }

}
