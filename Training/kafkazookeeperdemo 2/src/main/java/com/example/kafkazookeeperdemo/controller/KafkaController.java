package com.example.kafkazookeeperdemo.controller;

import com.example.kafkazookeeperdemo.entity.Employee;
import com.example.kafkazookeeperdemo.producerconsumer.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Employee employee) throws JsonProcessingException {
        //ObjectMapper objectMapper = new ObjectMapper();
        //String employeeString = objectMapper.writeValueAsString(employee);
        this.producer.sendMessage(employee);       //String must be passed here
//        byte[] byteStream = objectMapper.writeValueAsBytes(employee);
        //this.producer.sendMessage(byteStream);
    }
}
