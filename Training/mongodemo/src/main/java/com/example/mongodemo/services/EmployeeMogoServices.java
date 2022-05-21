package com.example.mongodemo.services;

import com.example.mongodemo.document.Employee;

import java.util.List;

public interface EmployeeMogoServices {
    List<Employee> saveAll(Iterable<Employee> employeeList);
    List<Employee> findAll();
    Employee insert(Employee employee);
}
