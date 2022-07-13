package com.example.employeeManagementSystem.ems.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Employees")
@Entity
@Data
public class Employee {
  @Id
  @SequenceGenerator(
          name = "employee_sequence",
          sequenceName = "employee_sequence",
          allocationSize = 1
  )
  @GeneratedValue (
          strategy = GenerationType.SEQUENCE,
          generator = "employee_sequence"
  )
  Long Id;
  String firstName;
  String lastName;
  LocalDate dateOfBirth;
  Integer age;
  Boolean isAdmin;
  String email;
}
