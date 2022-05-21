package com.example.employeecollection.repository;

import com.example.employeecollection.entity.EmployeePostgres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface EmployeeRepositoryPostgres extends CrudRepository<EmployeePostgres , Integer> {
}
