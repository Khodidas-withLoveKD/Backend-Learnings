package com.example.springmongorefresh.entity;

import com.example.springmongorefresh.entity.models.Address;
import com.example.springmongorefresh.entity.models.Gender;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Student {
  private String firstName;
  private String lastName;
  private String email;
  private Gender gender;
  private Address address;
  private List<String> favoriteSubjects;
  private BigDecimal totalSpentOnBooks;
  private ZonedDateTime createdAt;
}
