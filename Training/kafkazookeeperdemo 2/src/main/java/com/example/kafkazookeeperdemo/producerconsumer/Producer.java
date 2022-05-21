package com.example.kafkazookeeperdemo.producerconsumer;

import com.example.kafkazookeeperdemo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage(Employee message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        System.out.println("Message produced");
        this.kafkaTemplate.send(TOPIC, message);
    }
}
