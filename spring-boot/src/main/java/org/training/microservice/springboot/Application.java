package org.training.microservice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.training.library.ConConfig;

//@SpringBootApplication(scanBasePackages = {"org.training.microservice.springboot",
//                                           "org.training.library"
//})

@SpringBootApplication
@Import(ConConfig.class)
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(Application.class,
                                                                          args);
    }

}
