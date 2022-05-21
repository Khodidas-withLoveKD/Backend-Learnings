package com.example.mongodemo.repository;

import com.example.mongodemo.document.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMongoRepository extends MongoRepository<Employee, Integer> {
}
