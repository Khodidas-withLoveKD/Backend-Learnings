package com.example.kafkazookeeperdemo.producerconsumer;

import com.example.kafkazookeeperdemo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(Employee message) throws IOException {
        System.out.println("Message consumed");
        logger.info(String.format("#### -> Consumed message -> %s", message));
        System.out.println("EMP: "+ message);
    }
}
