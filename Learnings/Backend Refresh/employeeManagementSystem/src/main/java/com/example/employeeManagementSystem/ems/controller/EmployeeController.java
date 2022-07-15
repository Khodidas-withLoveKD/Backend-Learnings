package com.example.employeeManagementSystem.ems.controller;

import com.example.employeeManagementSystem.ems.entity.Employee;
import com.example.employeeManagementSystem.ems.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/ems/")
public class EmployeeController {

  @Autowired
  EmployeeServices employeeServices;

  @GetMapping(value = "getEmployeeByEmail")
  Employee getEmployeeByEmail(@RequestParam String email) {
    return employeeServices.getEmployeeByEmail(email);
  }

  @GetMapping(value = "getEmployee/:id")
  Employee getEmployeeById(@PathVariable Long id) {
    return employeeServices.getEmployeeById(id);
  }
}

/*
TODO
 1. Setup DB
 */