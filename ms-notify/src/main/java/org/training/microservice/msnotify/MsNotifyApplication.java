package org.training.microservice.msnotify;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MsNotifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsNotifyApplication.class,
                              args);
    }

}
