package com.example.demohelloworld.controller;

import com.example.demohelloworld.services.HelloWorldServices;
import com.example.demohelloworld.services.impl.HelloWorldServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldServices helloWorldServices;

    @GetMapping(value = "/")
    public String getMessage() {
        return "Hello World!!";
    }

    @GetMapping(value = "/service")
    public String getServicesMessage() {
        return helloWorldServices.getMessage();
    }
}