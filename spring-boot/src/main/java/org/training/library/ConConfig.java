package org.training.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConConfig {

    @Bean
    public ConUtil conUtil(){
        return new ConUtil();
    }
}
