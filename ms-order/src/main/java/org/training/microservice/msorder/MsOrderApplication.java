package org.training.microservice.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.training.microservice.mscommon.error.ErrorConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(ErrorConfig.class)
@EnableFeignClients
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@ServletComponentScan
public class MsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
