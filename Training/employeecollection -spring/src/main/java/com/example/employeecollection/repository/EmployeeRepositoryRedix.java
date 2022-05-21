package com.example.employeecollection.repository;

import com.example.employeecollection.entity.EmployeeRedix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryRedix extends CrudRepository<EmployeeRedix , Integer> {
}
