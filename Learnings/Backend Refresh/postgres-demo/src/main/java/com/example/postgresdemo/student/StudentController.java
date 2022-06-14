package com.example.postgresdemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  @GetMapping
  public List<StudentEntity> getStudents() {
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
