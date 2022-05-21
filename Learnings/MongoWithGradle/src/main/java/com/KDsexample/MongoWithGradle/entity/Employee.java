package com.KDsexample.MongoWithGradle.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Data
public class Employee {
    @Id
    private int id;
    private String name;
    private Date DOB;
    private int age;    //try to calculate this automatically
    private int salary;
    // use @builder / @data to set getters and setters
}
