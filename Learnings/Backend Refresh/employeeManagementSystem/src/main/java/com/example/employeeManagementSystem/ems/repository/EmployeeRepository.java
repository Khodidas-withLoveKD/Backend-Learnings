package com.example.employeeManagementSystem.ems.repository;

import com.example.employeeManagementSystem.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Query("SELECT emp FROM Employee emp WHERE emp.email=?1")
  Optional<Employee> findEmployeeByEmail(String email);
}
