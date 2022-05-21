package com.example.redisdemo.controller;

import com.example.redisdemo.entity.Employee;
import com.example.redisdemo.services.RedisEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/employee")
public class RedisEmployeeController {

    @Autowired
    RedisEmployeeServices redisEmployeeServices;

    @GetMapping(value = "/{employeeId}")
    public Employee findById(int id){
        return redisEmployeeServices.findById(id);
    }

    @GetMapping (value = "/findAll")
    public List<Employee> findAll(){
        return redisEmployeeServices.findAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return redisEmployeeServices.save(employee);
    }

    @DeleteMapping(value = "/delete/{deleteId}")
    public void deleteById(@PathVariable("deleteId") int id){
        redisEmployeeServices.deleteById(id);
    }
}
