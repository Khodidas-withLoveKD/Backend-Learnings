package com.example.mongodemo.controller;

import com.example.mongodemo.document.Employee;
import com.example.mongodemo.services.EmployeeMogoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeMogoServices employeeMogoServices;

    @GetMapping (value = "/saveAll/{list}")
    public List<Employee> saveAll(@PathVariable ("list") Iterable<Employee> employeeList){
        return employeeMogoServices.saveAll(employeeList);
    }

    @GetMapping (value = "/findAll")
    public List<Employee> findAll(){
        return employeeMogoServices.findAll();
    }

    @PostMapping (value = "/insert")
    public Employee insert(@RequestBody Employee employee){
        return employeeMogoServices.insert(employee);
    }

}
