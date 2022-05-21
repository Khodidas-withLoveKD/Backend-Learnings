package com.example.employeecollection.repository;

import com.example.employeecollection.entity.EmployeeMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryMongo extends MongoRepository<EmployeeMongo , Integer> {
}
