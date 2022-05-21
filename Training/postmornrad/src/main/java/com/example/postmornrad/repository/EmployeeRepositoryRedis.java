package com.example.postmornrad.repository;

import com.example.postmornrad.entity.EmployeeRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryRedis extends CrudRepository<EmployeeRedis,String> {

}
