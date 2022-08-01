package com.example.employeeManagementSystem.ems.services;

import com.example.employeeManagementSystem.ems.entity.Employee;
import com.example.employeeManagementSystem.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

  @Override
  public Employee getEmployeeById (Long empId) {
    return employeeRepository.findById(empId)
            .orElseThrow(() -> new IllegalStateException(
                    "Employee with Id: " + empId + " does not exists :("
            ));
  }

  @Override
  public void createEmployee (Employee employee) {

    Optional<Employee> anotherEmployee =
            employeeRepository.getEmployeeByEmail(employee.getEmail());
    if (anotherEmployee.isPresent()) {
      throw new IllegalStateException(
              "Employee with this email (" + employee.getEmail() + ") already exists :("
      );
    }
    employeeRepository.save(employee);
  }

  @Override
  public void deleteEmployeeByEmail(String email) {
    // check if emp with email exists
    Optional<Employee> employee = employeeRepository.getEmployeeByEmail(email);
    if (!employee.isPresent()) {
      throw new IllegalStateException(
              "Employee with email " + email + " does not exists"
      );
    }

    employeeRepository.deleteEmployeeByEmail(email);
  }
}
