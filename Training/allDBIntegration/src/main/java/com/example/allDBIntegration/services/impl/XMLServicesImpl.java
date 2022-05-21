package com.example.allDBIntegration.services.impl;

import com.example.allDBIntegration.entities.XMLEmployee;
import com.example.allDBIntegration.repositories.XMLRepository;
import com.example.allDBIntegration.services.XMLServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XMLServicesImpl implements XMLServices {

    @Autowired
    XMLRepository xmlRepository;

    XMLEmployee xmlEmployee;

    @Override
    public XMLEmployee save(XMLEmployee employee){
        return xmlRepository.save(employee);
    }

    @Override
    public XMLEmployee findById(int id){
        return xmlRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id){
        xmlRepository.deleteById(id);
    }

    @Override
    public List<XMLEmployee> findAll(){
        Iterable<XMLEmployee> xmlEmployeeIterable = xmlRepository.findAll();
        List<XMLEmployee> xmlEmployeeList = new ArrayList<>();
        xmlEmployeeIterable.forEach(xmlEmployeeList :: add);
        return xmlEmployeeList;
    }

    @Override
    public void read(){
        xmlRepository.save(xmlEmployee);
    }

    @Override
    public void write(){
        xmlRepository.findAll();
    }
}
