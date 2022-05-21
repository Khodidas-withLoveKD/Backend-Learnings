package com.example.employeecollection.services;

import com.example.employeecollection.entity.EmployeeMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServicesMongo {
    EmployeeMongo insert(EmployeeMongo employee);
    List<EmployeeMongo> findAll();
}
