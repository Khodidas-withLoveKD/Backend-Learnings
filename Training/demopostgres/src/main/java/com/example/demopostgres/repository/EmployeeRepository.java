package com.example.demopostgres.repository;

import com.example.demopostgres.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    //you can add your own method like this and function name should match with vars (entity fields and entity name should follow camelCase), and find/delete..etc + By hovu joiye
    List<Employee> findByFirstName(String firstName);

    //or write a query above method
    @Query (value = "select count(1) from employee", nativeQuery = true)    //true = directly execute, false = check query if true then execute
    Long countSomething();

    @Query (value = "select count(1) from employee where id = 10", nativeQuery = true)
    Long countSomething2(long id);
}