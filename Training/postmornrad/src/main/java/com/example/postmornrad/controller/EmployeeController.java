package com.example.postmornrad.controller;


import com.example.postmornrad.ReadThread;
import com.example.postmornrad.WriteThread;
import com.example.postmornrad.filehandler.*;
import com.example.postmornrad.repository.EmployeeRepositoryMongo;
import com.example.postmornrad.repository.EmployeeRepositoryPostgres;
import com.example.postmornrad.repository.EmployeeRepositoryRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {


    @Autowired
    EmployeeRepositoryRedis employeeRepositoryRedis;
    @Autowired
    EmployeeRepositoryMongo employeeRepositoryMongo;

    @Autowired
    EmployeeRepositoryPostgres employeeRepositoryPostgres;


    @GetMapping(value = "/employee")
    public void process(String[] args) throws InterruptedException {




        Thread csvReadThread = new ReadThread(new CSVFileHandler(employeeRepositoryPostgres));
        Thread xmlReadThread = new ReadThread(new XMLFileHandler(employeeRepositoryRedis));
        Thread jsonReadThread = new ReadThread(new JSONFileHandler(employeeRepositoryMongo));

        csvReadThread.start();
        xmlReadThread.start();
        jsonReadThread.start();

        csvReadThread.join();
        xmlReadThread.join();
        jsonReadThread.join();



        Thread csvWriterThread = new WriteThread(new CSVFileHandler(employeeRepositoryPostgres));
        Thread xmlWriterThread = new WriteThread(new XMLFileHandler(employeeRepositoryRedis));
        Thread jsonWriterThread = new WriteThread(new JSONFileHandler(employeeRepositoryMongo));

        csvWriterThread.start();
        xmlWriterThread.start();
        jsonWriterThread.start();


            xmlWriterThread.join();
            csvWriterThread.join();
            jsonWriterThread.join();

    }





}
