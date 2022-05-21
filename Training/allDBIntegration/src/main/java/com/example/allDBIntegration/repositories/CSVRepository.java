package com.example.allDBIntegration.repositories;

import com.example.allDBIntegration.entities.CSVEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSVRepository extends CrudRepository<CSVEmployee, Integer> {
}
