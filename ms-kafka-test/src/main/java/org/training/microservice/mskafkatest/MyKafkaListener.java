package org.training.microservice.mskafkatest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

//    @KafkaListener(topics = "spring-test", groupId = "spring-test-group")
//    public void method(String stringParam) {
//        System.out.println("I got message : " + stringParam);
//    }

    @KafkaListener(topics = "spring-test", groupId = "spring-test-group", concurrency = "3")
    public void method(ConsumerRecord<String,String> consumerRecordParam) {
        System.out.println("I got message : " + consumerRecordParam);
    }

}
