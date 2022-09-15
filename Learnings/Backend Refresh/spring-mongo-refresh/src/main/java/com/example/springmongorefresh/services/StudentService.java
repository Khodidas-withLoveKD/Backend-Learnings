package com.example.springmongorefresh.services;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.entity.models.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentService {
  List<Student> getAllStudents();
  void addStudent(Student student);
  void deleteStudentByEmail(String email);
  void updateStudentNameAndAddress(String email, String firstName, String lastName, Address address);
  void updateStudent(Student student);
}
