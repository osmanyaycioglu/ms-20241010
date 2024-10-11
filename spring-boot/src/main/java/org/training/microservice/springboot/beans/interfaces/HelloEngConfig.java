package org.training.microservice.springboot.beans.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Profile("English")
@Configuration
public class HelloEngConfig {


    @Bean(name = "aval_hello")
    public IHello hello1(Environment environment) {
        return new HelloImpl();
    }

}

