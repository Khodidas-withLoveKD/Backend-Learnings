package com.example.allDBIntegration.services;

import com.example.allDBIntegration.entities.JSONEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JSONServices {
    List<JSONEmployee> saveAll(Iterable<JSONEmployee> employeeList);
    List<JSONEmployee> findAll();
    JSONEmployee insert(JSONEmployee employee);
    void read();
    void write();
}
