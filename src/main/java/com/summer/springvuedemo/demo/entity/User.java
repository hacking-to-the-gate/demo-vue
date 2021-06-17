package com.summer.springvuedemo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer userId;
  private String userName;
  private String password;
  private String role;
  private Integer status;

}
