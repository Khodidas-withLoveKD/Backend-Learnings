package com.example.postgresdemo.student.service.Impl;

import com.example.postgresdemo.student.StudentEntity;
import com.example.postgresdemo.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

  @Override
  public ArrayList<StudentEntity> getStudents() {
    return new ArrayList<StudentEntity>(){{add(new StudentEntity(
            1L,
            "Khodidas",
            "chauhan.khodidas@gmail.com",
            new Date(),
            23
    ));
    }};
  }
}
