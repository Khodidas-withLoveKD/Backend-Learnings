package com.example.postgresdemo.student.service;

import com.example.postgresdemo.student.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
  List<StudentEntity> getStudents();
}
