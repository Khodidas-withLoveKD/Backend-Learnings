package com.example.employeecollection.services.impl;

import com.example.employeecollection.entity.EmployeePostgres;
import com.example.employeecollection.handler.MyFileHandler;
import com.example.employeecollection.repository.EmployeeRepositoryPostgres;
import com.example.employeecollection.services.EmployeeServicesPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.io.*;
import java.text.*;
@Service
public class EmployeeServicesImplPostgres implements EmployeeServicesPostgres{
    @Autowired
    EmployeeRepositoryPostgres employeeRepositoryPostgres;
    @Override
    public EmployeePostgres save(EmployeePostgres employee) {
        return employeeRepositoryPostgres.save(employee);
    }

    @Override
    public EmployeePostgres findById(int id) {
        return employeeRepositoryPostgres.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        employeeRepositoryPostgres.deleteById(id);
    }

    @Override
    public List<EmployeePostgres> findAll() {
        Iterable<EmployeePostgres> employeeIterable = employeeRepositoryPostgres.findAll();
        List<EmployeePostgres> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList :: add);
        return employeeList;
    }
}

