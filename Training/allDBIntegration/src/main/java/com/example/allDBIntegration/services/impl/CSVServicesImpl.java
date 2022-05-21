package com.example.allDBIntegration.services.impl;

import com.example.allDBIntegration.entities.CSVEmployee;
import com.example.allDBIntegration.repositories.CSVRepository;
import com.example.allDBIntegration.services.CSVServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CSVServicesImpl implements CSVServices {

    @Autowired
    CSVRepository csvRepository;

    CSVEmployee csvEmployee;
    @Override
    public CSVEmployee save (CSVEmployee employee){
        return csvRepository.save(employee);
    }

    @Override
    public CSVEmployee findById(int id){
        return csvRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id){
        csvRepository.deleteById(id);
    }

    @Override
    public List<CSVEmployee> findAll(){
        Iterable<CSVEmployee> CSVEmployeeIterable = csvRepository.findAll();
        List<CSVEmployee> CSVEmployeeList = new ArrayList<>();
        CSVEmployeeIterable.forEach(CSVEmployeeList :: add);
        return CSVEmployeeList;
    }

    @Override
    public void read(){
        csvRepository.save(csvEmployee);
    }
    @Override
    public void write(){
        csvRepository.findAll();
    }
}
