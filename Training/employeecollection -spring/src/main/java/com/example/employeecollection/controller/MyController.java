package com.example.employeecollection.controller;

import com.example.employeecollection.handler.CSVFileHandler;
import com.example.employeecollection.handler.JsonFileHandler;
import com.example.employeecollection.handler.XMLFileHandler;
import com.example.employeecollection.services.EmployeeServicesPostgres;
import com.example.employeecollection.threads.ReadThread;
import com.example.employeecollection.threads.WriteThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeecollection.services.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController extends Thread {
    @Autowired
    EmployeeServicesPostgres employeeServicesPostgres;

    @Autowired
    EmployeeServicesRedix employeeServicesRedix;

    @Autowired
    EmployeeServicesMongo employeeServicesMongo;

    @PostMapping(value = "/post")
    public void post() {
        start();
    }


    @Override
    public void run() {
        ReadThread readThreadCSV = new ReadThread(new CSVFileHandler(employeeServicesPostgres));
        readThreadCSV.start();

        ReadThread readThreadJSON = new ReadThread(new JsonFileHandler(employeeServicesMongo));
        readThreadJSON.start();
        ReadThread readThreadXML = new ReadThread(new XMLFileHandler(employeeServicesRedix));
        readThreadXML.start();


        try {
            readThreadCSV.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            readThreadJSON.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            readThreadXML.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WriteThread writeThreadCSV = new WriteThread(new CSVFileHandler(employeeServicesPostgres));
        writeThreadCSV.start();

        WriteThread writeThreadJSON = new WriteThread(new JsonFileHandler(employeeServicesMongo));
        writeThreadJSON.start();

        WriteThread writeThreadXML = new WriteThread(new XMLFileHandler(employeeServicesRedix));
        writeThreadXML.start();

        try {
            writeThreadCSV.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            writeThreadJSON.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            writeThreadXML.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
