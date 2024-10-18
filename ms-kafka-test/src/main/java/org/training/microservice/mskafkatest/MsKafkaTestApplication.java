package org.training.microservice.mskafkatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MsKafkaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsKafkaTestApplication.class,
                              args);
    }

}
