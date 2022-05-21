package com.example.demopostgres.controller;

import com.example.demopostgres.entity.Employee;
import com.example.demopostgres.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;

    @GetMapping (value = "/{employeeId}")
    Employee findById(@PathVariable("employeeId") int id){
        return employeeServices.findById(id);
    }

    @GetMapping (value = "/findAll")
    List<Employee> findAll(){
        return  employeeServices.findAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeServices.save(employee);
    }

    @GetMapping (value = "findByFirstName")
    public List<Employee> findByFirstName

    @DeleteMapping (value = "/delete/{deleteId}")
    public void deleteById(@PathVariable ("deleteId") int id){
        employeeServices.deleteById(id);
    }
}
