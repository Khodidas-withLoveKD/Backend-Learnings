package com.example.redisdemo.services;

import com.example.redisdemo.entity.Employee;
import java.util.List;

public interface RedisEmployeeServices {
    Employee save(Employee employee);
    Employee findById(int id);
    void deleteById(int id);
    List<Employee> findAll();
}
