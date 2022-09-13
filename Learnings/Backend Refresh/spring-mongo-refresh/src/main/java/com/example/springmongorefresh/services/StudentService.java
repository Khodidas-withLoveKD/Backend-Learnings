package com.example.springmongorefresh.services;

import com.example.springmongorefresh.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
  List<Student> getAllStudents();
  void addStudent(Student student);
}
