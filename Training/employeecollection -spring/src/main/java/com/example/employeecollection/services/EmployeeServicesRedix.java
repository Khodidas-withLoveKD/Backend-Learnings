package com.example.employeecollection.services;

import com.example.employeecollection.entity.EmployeeRedix;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServicesRedix {
    EmployeeRedix save(EmployeeRedix employee);
    EmployeeRedix findById(int id);
    void deleteById(int id);
    List<EmployeeRedix> findAll();
}
