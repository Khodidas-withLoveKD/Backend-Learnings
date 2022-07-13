package com.example.employeeManagementSystem.ems.controller;

import com.example.employeeManagementSystem.ems.entity.Employee;
import com.example.employeeManagementSystem.ems.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/ems/")
public class EmployeeController {

  @Autowired
  EmployeeServices EmployeeServices;

  @GetMapping(value = "getEmployee")
  Employee getEmployeeByEmail(@RequestParam String email) {
    return EmployeeServices.getEmployeeByEmail(email);
  }
}
