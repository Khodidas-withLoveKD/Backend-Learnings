package com.example.springmongorefresh.controller;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/mongodb/student/")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping(value = "getAllStudents")
  List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }
}
