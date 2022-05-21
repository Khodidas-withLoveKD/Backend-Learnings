package com.example.demopostgres.services.impl;

import com.example.demopostgres.entity.Employee;
import com.example.demopostgres.repository.EmployeeRepository;
import com.example.demopostgres.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional (readOnly = true)
    @Override
    public Employee save (Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id){
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee>
    @Override
    public List<Employee> findAll(){
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList :: add);
        return employeeList;
    }
}
