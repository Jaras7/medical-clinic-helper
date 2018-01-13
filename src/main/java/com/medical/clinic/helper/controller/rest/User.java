package com.medical.clinic.helper.controller.rest;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String login;
  private String firstname;
  private String lastname;
  private String password;
  private String email;
  private LocalDateTime birthdayDate;
}
