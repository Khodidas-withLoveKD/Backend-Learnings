package com.example.employeeManagementSystem.ems.services;

import com.example.employeeManagementSystem.ems.entity.Employee;
import com.example.employeeManagementSystem.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public Employee getEmployeeByEmail(String email) {

    return employeeRepository.getEmployeeByEmail(email)
            .orElseThrow(() -> new IllegalStateException(
                    "Employee with email: " + email + " does not exists :("
            ));
  }
}
