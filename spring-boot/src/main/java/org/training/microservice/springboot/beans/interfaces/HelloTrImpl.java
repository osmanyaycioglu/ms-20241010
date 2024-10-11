package org.training.microservice.springboot.beans.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("turkce_hello")
@Component
public class HelloTrImpl implements IHello {
    @Override
    public String hello(final String name,
                        final String surname) {
        return "Merhaba " + name + " " + surname;
    }
}
