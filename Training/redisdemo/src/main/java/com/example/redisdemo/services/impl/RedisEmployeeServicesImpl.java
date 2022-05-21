package com.example.redisdemo.services.impl;

import com.example.redisdemo.entity.Employee;
import com.example.redisdemo.repository.RedisEmployeeRepository;
import com.example.redisdemo.services.RedisEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisEmployeeServicesImpl implements RedisEmployeeServices {

    @Autowired
    RedisEmployeeRepository redisEmployeeRepository;

    @Override
    public Employee save(Employee employee){
        return redisEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id){
        return redisEmployeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id){
        redisEmployeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll(){
        Iterable<Employee> employeeIterable = redisEmployeeRepository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList :: add);
        return employeeList;
    }
}
