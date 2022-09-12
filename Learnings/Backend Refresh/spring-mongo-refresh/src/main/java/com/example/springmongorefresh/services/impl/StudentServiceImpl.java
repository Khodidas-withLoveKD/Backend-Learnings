package com.example.springmongorefresh.services.impl;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.repository.StudentRepository;
import com.example.springmongorefresh.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
}
