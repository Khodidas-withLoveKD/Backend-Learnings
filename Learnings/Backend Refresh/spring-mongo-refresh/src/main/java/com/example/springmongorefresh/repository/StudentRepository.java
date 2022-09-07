package com.example.springmongorefresh.repository;

import com.example.springmongorefresh.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
