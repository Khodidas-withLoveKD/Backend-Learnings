package com.example.allDBIntegration.services.impl;

import com.example.allDBIntegration.entities.JSONEmployee;
import com.example.allDBIntegration.repositories.JSONRepository;
import com.example.allDBIntegration.services.JSONServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JSONServicesImpl implements JSONServices {
    @Autowired
    JSONRepository jsonRepository;

    JSONEmployee employee;
    @Override
    public List<JSONEmployee> saveAll(Iterable<JSONEmployee> jsonEmployeeList){
        List<JSONEmployee> JSONEmployeelist = jsonRepository.saveAll(jsonEmployeeList);
        return JSONEmployeelist;
    }

    @Override
    public List<JSONEmployee> findAll(){
        Iterable<JSONEmployee> JSONEmployeeIterable = jsonRepository.findAll();
        List<JSONEmployee> JSONEmployeelist = new ArrayList<>();
        JSONEmployeeIterable.forEach(JSONEmployeelist :: add);
        return JSONEmployeelist;
    }
    @Override
    public JSONEmployee insert(JSONEmployee JSONEmployee){
        return jsonRepository.insert(JSONEmployee);
    }

    @Override
    public void read(){
        //make object of filehandler
        jsonRepository.insert(employee);

    }
    @Override
    public void write(){
        jsonRepository.findAll();
    }
}
