package org.training.microservice.apitestcaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.web.reactive.function.client.ServletBearerExchangeFilterFunction;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebSecurity
public class SecConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize.anyRequest()
                                                                .authenticated())
                   .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
                   .build();
    }
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                        .filter(new ServletBearerExchangeFilterFunction())
                        .build();
    }

}
