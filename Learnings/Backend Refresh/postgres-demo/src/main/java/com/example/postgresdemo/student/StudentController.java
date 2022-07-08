package com.example.postgresdemo.student;

import com.example.postgresdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping
  public List<Student> getStudents() {
   return studentService.getStudents();
  }

  @PostMapping
  public void registerStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudentNameAndEmail(
          @PathVariable("studentId") Long studentId,
          @RequestParam(required = false) String name,
          @RequestParam(required = false) String email) {
      studentService.updateStudentNameAndEmail(studentId, name, email);
  }
}
