package com.example.allDBIntegration.services;

import com.example.allDBIntegration.entities.CSVEmployee;
import java.util.List;


public interface CSVServices {
    CSVEmployee save(CSVEmployee employee);
    CSVEmployee findById(int id);
    void deleteById(int id);
    List<CSVEmployee> findAll();
    void read();
    void write();
}
