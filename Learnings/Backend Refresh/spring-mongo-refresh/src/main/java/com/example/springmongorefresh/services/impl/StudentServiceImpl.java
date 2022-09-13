package com.example.springmongorefresh.services.impl;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.repository.StudentRepository;
import com.example.springmongorefresh.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public void addStudent(Student student) {
    Optional<Student> anotherStudent = studentRepository.findStudentByEmail(student.getEmail());
    if(anotherStudent.isPresent()) {
      throw new IllegalStateException(" Student with email " + student.getEmail() + " already exist!!");
    }
    
    studentRepository.save(student);
  }

  @Override
  public void deleteStudentByEmail(String email) {
    Optional<Student> anotherStudent = studentRepository.findStudentByEmail(email);
    if(!anotherStudent.isPresent()) {
      throw new IllegalStateException("Unable to delete student. Student with email " + email + " does not exist!!");
    }

    studentRepository.deleteStudentByEmail(email);
  }
}
