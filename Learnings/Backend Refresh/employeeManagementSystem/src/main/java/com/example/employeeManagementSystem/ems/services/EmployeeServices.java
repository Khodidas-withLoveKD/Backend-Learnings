package com.example.employeeManagementSystem.ems.services;

import com.example.employeeManagementSystem.ems.entity.Employee;

public interface EmployeeServices {

  Employee getEmployeeByEmail(String email);

  Employee getEmployeeById (Long empId);
}