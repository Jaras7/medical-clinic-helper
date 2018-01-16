package com.medical.clinic.helper.user.dto;

import lombok.Data;

@Data
public class UserQueryDto {

  private String login;
  private String firstname;
  private String lastname;
  private String password;
  private String email;
}
