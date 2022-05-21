package com.example.allDBIntegration.repositories;

import com.example.allDBIntegration.entities.JSONEmployee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface JSONRepository extends MongoRepository<JSONEmployee, Integer>{
}