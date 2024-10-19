package org.training.microservice.apigwoauthtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableWebFluxSecurity
public class ApigwOauthTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigwOauthTestApplication.class,
                              args);
    }

}
