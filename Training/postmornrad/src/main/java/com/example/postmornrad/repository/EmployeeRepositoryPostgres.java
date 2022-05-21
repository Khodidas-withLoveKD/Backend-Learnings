package com.example.postmornrad.repository;


import com.example.postmornrad.entity.EmployeePostgres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryPostgres extends CrudRepository<EmployeePostgres,String> {

}
