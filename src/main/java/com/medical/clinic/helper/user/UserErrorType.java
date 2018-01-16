package com.medical.clinic.helper.user;

import lombok.Getter;

@Getter
class UserErrorType {

  private String message;

  UserErrorType(String message) {
    this.message = message;
  }
}
