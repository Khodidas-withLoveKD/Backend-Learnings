package com.example.allDBIntegration.services;

import com.example.allDBIntegration.entities.XMLEmployee;

import java.util.List;

public interface XMLServices {
    XMLEmployee save(XMLEmployee xmlEmployee);
    XMLEmployee findById(int id);
    void deleteById(int id);
    List<XMLEmployee> findAll();
    void read();
    void write();
}
