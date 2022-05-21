package com.example.demoscope.controller;

import com.example.demoscope.services.SingletonServices;
import dto.PurchaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
@Scope (value = "request")      //"request" - for request level, executed during request creates bean //"Session" - for session time , till session dies //"prototype' - only when autowiring thaay
public class SingletonController {

    @Autowired
    SingletonServices singletonServices2;

    @Autowired
    SingletonServices singletonServices;

    PurchaseHistory
    public SingletonController(){
        System.out.println("Inside NO Argument Contructor");
    }


    @Autowired
    public SingletonController(SingletonServices singletonServices) {
        this.singletonServices = singletonServices;
        System.out.println("Inside Contructor");
    }

    @GetMapping (value = "/message")
    public String getMessage(){
        if(singletonServices == singletonServices2)
            return "Equal chee";
        return singletonServices.getMessage() + " "+ this.singletonServices+ "\n" + this.singletonServices2;
    }

    @PostConstruct
    public void init(){
        if(this.singletonServices == null)
            System.out.println("Spring no depedencies");
        else
            System.out.println("Good work spring");
    }

    @PreDestroy     //to destroy bean
    public void destroy(){
        System.out.println("During destroy");
    }
}
