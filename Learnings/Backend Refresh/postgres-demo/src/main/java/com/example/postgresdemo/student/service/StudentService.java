package com.example.postgresdemo.student.service;

import com.example.postgresdemo.student.StudentEntity;

import java.util.ArrayList;

public interface StudentService {
  ArrayList<StudentEntity> getStudents();
}
