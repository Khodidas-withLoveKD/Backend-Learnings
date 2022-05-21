package com.example.demohelloworld.services.impl;

import com.example.demohelloworld.repository.HelloWorldRepository;
import com.example.demohelloworld.services.HelloWorldServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServicesImpl implements HelloWorldServices {

    @Autowired
    HelloWorldRepository helloWorldRepository;

    @Override
    public String getMessage() {
        return "Hello World services!! " + helloWorldRepository.getMessage();
    }
}
