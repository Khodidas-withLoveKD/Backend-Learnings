package com.example.springmongorefresh.controller;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.entity.models.Address;
import com.example.springmongorefresh.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  // Get student by email

  // insert student
  @PostMapping(value = "addStudent")
  void registerStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  // delete student
  @DeleteMapping(value = "deleteStudent")
  void deleteStudentByEmail(@RequestParam String studentEmail) {
    studentService.deleteStudentByEmail(studentEmail);
  }

  // update student Name and address by email
  @PutMapping(value = "updateStudentNameAndAddress")
  void updateStudentNameAndAddress(@RequestParam(value = "email")String studentEmail, @RequestParam(value = "firstName") String studentFirstName, @RequestParam(value = "lastName") String studentLastName, @RequestBody Address studentAddress) {
    studentService.updateStudentNameAndAddress(studentEmail, studentFirstName, studentLastName, studentAddress);
  }
}
