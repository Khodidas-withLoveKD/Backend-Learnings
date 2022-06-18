package com.example.postgresdemo.student;

import com.example.postgresdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping
  public List<StudentEntity> getStudents() {
   return studentService.getStudents();
  }
}
