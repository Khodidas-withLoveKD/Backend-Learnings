package com.example.postgresdemo.student.service;

import com.example.postgresdemo.student.Student;

import java.util.List;

public interface StudentService {
  List<Student> getStudents();

  void addNewStudent(Student student);
}
