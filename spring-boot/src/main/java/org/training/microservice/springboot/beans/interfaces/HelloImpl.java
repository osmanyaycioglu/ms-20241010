package org.training.microservice.springboot.beans.interfaces;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Primary
@Component
public class HelloImpl implements IHello {
    @Override
    public String hello(final String name,
                        final String surname) {
        return "Hello " + name + " " + surname;
    }
}
