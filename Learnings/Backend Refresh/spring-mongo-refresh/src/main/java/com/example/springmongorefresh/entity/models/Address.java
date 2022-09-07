package com.example.springmongorefresh.entity.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
  private String city;
  private Integer postCode;
  private String country;
}
