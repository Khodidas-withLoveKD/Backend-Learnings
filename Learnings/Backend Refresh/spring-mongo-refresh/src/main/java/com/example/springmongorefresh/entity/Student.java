package com.example.springmongorefresh.entity;

import com.example.springmongorefresh.entity.models.Address;
import com.example.springmongorefresh.entity.models.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private Gender gender;
  private Address address;
  private List<String> favoriteSubjects;
  private BigDecimal totalSpentOnBooks;
  private LocalDateTime createdAt;

  public Student(String firstName,
                 String lastName,
                 String email,
                 Gender gender,
                 Address address,
                 List<String> favoriteSubjects,
                 BigDecimal totalSpentOnBooks,
                 LocalDateTime createdAt) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.address = address;
    this.favoriteSubjects = favoriteSubjects;
    this.totalSpentOnBooks = totalSpentOnBooks;
    this.createdAt = createdAt;
  }
}
