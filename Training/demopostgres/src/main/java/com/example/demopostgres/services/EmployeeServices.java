package com.example.demopostgres.services;

import com.example.demopostgres.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    Employee save(Employee employee);
    Employee findById(int id);
    void deleteById(int id);
    List<Employee> findAll();
    public List<Employee> findByFirstName (String firstName);
}
