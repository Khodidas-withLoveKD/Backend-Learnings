package com.example.employeecollection.services.impl;

import com.example.employeecollection.entity.EmployeeMongo;
import com.example.employeecollection.handler.JsonFileHandler;
import com.example.employeecollection.handler.MyFileHandler;
import com.example.employeecollection.repository.EmployeeRepositoryMongo;
import com.example.employeecollection.services.EmployeeServicesMongo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
@Service
public class EmployeeServicesImplMongo implements EmployeeServicesMongo{
    @Autowired
    EmployeeRepositoryMongo employeeRepositoryMongo;

    @Override
    public EmployeeMongo insert(EmployeeMongo employee) {
        return employeeRepositoryMongo.insert(employee);
    }

    @Override
    public List<EmployeeMongo> findAll() {
        return employeeRepositoryMongo.findAll();
    }
}

