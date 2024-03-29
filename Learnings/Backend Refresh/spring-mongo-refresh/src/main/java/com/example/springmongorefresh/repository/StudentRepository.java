package com.example.springmongorefresh.repository;

import com.example.springmongorefresh.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

  Optional<Student> findStudentByEmail(String email);

  @Transactional
  void deleteStudentByEmail(String email);
}
