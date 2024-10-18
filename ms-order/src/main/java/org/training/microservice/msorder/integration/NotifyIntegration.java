package org.training.microservice.msorder.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.training.microservice.msorder.integration.models.NotifyMessageOrder;

@Service
@RequiredArgsConstructor
public class NotifyIntegration {
    private final RabbitTemplate rabbitTemplate;

    public void sendNotifySms(String message,
                              String destination) {
        rabbitTemplate.convertAndSend("notify-topic-exchange",
                                      "notification.alarm.eu.tr.sms.istanbul",
                                      new NotifyMessageOrder(message,
                                                             destination));

    }

}
