package com.example.postmornrad.repository;

import com.example.postmornrad.entity.EmployeeMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryMongo extends MongoRepository<EmployeeMongo,String> {

}
