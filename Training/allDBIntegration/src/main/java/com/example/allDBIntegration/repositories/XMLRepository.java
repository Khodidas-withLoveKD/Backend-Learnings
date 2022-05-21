package com.example.allDBIntegration.repositories;

import com.example.allDBIntegration.entities.XMLEmployee;
import org.springframework.data.repository.CrudRepository;

public interface XMLRepository extends CrudRepository<XMLEmployee, Integer> {
}
