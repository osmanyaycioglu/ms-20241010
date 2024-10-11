package org.training.microservice.springboot.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.training.library.ConUtil;
import org.training.microservice.springboot.beans.interfaces.IHello;

import java.util.List;

//@Controller
//@Repository
//@Service
//@Configuration


@Component
public class MyStarter implements ApplicationRunner {
    @Autowired
    private       MyCustomerCache myCustomerCache;
    private final MyCustomerCache myCustomerCache2;
    private final IHello          hello;
    private final IHello          helloTr;
    private       MyCustomerCache myCustomerCache3;
    @Autowired
    private       IHello[]        hellos;
    @Autowired
    private       List<IHello>    hellos2;

    @Autowired
    private ConUtil conUtil;

    public MyStarter(MyCustomerCache myCustomerCache2,
                     @Qualifier("aval_hello") IHello hello,
                     @Qualifier("helloImpl") IHello hello2) {
        this.myCustomerCache2 = myCustomerCache2;
        this.hello            = hello;
        helloTr               = hello2;
    }


    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println(hello.hello("osman",
                                       "yaycıoğlu"));
    }

    @Autowired
    public void mi(MyCustomerCache myCustomerCache3Param) {
        myCustomerCache3 = myCustomerCache3Param;
    }

    @PostConstruct
    public void init() {
        // Init kodu
    }
}
