package com.example.mongodemo.services.impl;

import com.example.mongodemo.document.Employee;
import com.example.mongodemo.repository.EmployeeMongoRepository;
import com.example.mongodemo.services.EmployeeMogoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMongoServicesImpl implements EmployeeMogoServices {

    @Autowired
    EmployeeMongoRepository employeeMongoRepository;

    @Override
    public List<Employee> saveAll(Iterable<Employee> employeeList){
        List<Employee> employeelist = employeeMongoRepository.saveAll(employeeList);
        // Iterable<Employee> employeeIterable = employeeMongoRepository.saveAll(employeeList);
        //List<Employee> employeelist = new ArrayList<>();
        //employeeIterable.forEach(employeelist :: add);
        return employeelist;
    }

    @Override
    public List<Employee> findAll(){
        Iterable<Employee> employeeIterable = employeeMongoRepository.findAll();
        List<Employee> employeelist = new ArrayList<>();
        employeeIterable.forEach(employeelist :: add);
        return employeelist;
    }

    @Override
    public Employee insert(Employee employee){
        return employeeMongoRepository.insert(employee);
    }
}
