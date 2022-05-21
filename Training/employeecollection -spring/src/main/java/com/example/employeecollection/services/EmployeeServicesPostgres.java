package com.example.employeecollection.services;

import com.example.employeecollection.entity.EmployeePostgres;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeServicesPostgres {
    EmployeePostgres save(EmployeePostgres employee);
    EmployeePostgres findById(int id);
    void deleteById(int id);
    List<EmployeePostgres> findAll();
}
