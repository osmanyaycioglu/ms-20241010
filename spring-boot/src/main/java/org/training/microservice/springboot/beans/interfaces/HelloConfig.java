package org.training.microservice.springboot.beans.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:my.properties")
@RequiredArgsConstructor
public class HelloConfig {
    @Value("${my.app.language}")
    private String language;

    @Bean(name = "current_hello")
    public IHello hello1(Environment environment) {
        String propertyLoc = environment.getProperty("my.app.language");
        switch (propertyLoc) {
            case "tr":
                return new HelloTrImpl();
            case "eng":
            default:
                return new HelloImpl();
        }
    }

    @Bean(name = "another_hello")
    public IHello hello2() {
        switch (language) {
            case "tr":
                return new HelloTrImpl();
            case "eng":
            default:
                return new HelloImpl();
        }
    }

}
