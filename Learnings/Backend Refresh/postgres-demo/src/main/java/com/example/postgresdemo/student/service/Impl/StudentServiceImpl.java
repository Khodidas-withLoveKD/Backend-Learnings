package com.example.postgresdemo.student.service.Impl;

import com.example.postgresdemo.student.Student;
import com.example.postgresdemo.student.repository.StudentRepository;
import com.example.postgresdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  @Override
  public void addNewStudent(Student student) {
//    return studentRepository.save(student);
    Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
    if (studentEmail.isPresent()) {
      throw new IllegalStateException("Email already taken");
    }
    studentRepository.save(student);
    System.out.println(student);
  }
}
