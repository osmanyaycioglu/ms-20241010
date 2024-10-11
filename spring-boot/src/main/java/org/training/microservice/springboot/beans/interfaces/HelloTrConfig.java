package org.training.microservice.springboot.beans.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Profile("Turkish")
@Configuration
public class HelloTrConfig {


    @Bean(name = "aval_hello")
    public IHello hello1(Environment environment) {
        return new HelloTrImpl();
    }

}

