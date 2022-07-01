package com.example.postgresdemo.student.service.Impl;

import com.example.postgresdemo.student.StudentEntity;
import com.example.postgresdemo.student.repository.StudentRepository;
import com.example.postgresdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<StudentEntity> getStudents() {
    return studentRepository.findAll();
  }
}
