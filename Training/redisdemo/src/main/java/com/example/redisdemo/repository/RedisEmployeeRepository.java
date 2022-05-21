package com.example.redisdemo.repository;

import com.example.redisdemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisEmployeeRepository extends CrudRepository<Employee, Integer> { }
