package com.example.postgresdemo.student;

import com.example.postgresdemo.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner (StudentRepository repository) {
    return args -> {
      Student mariam = new Student(
            1L,
            "Mariam",
            "mari.afd@gmail.com",
            LocalDate.of(1998, Month.JANUARY, 12)
      );
      Student alex = new Student(
            1L,
            "Alex",
            "alex.d@gmail.com",
            LocalDate.of(2002, Month.APRIL, 13)

      );
      repository.saveAll(
              Arrays.asList(mariam, alex)
      );
    };
  }
}
