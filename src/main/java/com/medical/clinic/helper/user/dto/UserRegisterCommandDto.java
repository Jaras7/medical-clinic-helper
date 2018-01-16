package com.medical.clinic.helper.user.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class UserRegisterCommandDto {
  private String login;
  private String firstname;
  private String lastname;
  private String password;
  private String email;
  private String phone;
  private String pesel;
  private LocalDate birthday;
  private LocalDateTime created;
  private LocalDateTime updated;
}
