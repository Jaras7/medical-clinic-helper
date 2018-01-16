package com.medical.clinic.helper.user;

import com.medical.clinic.helper.user.dto.UserRegisterCommandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
class UserRegistrationController {

  private final UserFacade userFacade;

  @Autowired
  UserRegistrationController(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @RequestMapping(method = RequestMethod.POST)
  ResponseEntity<?> performRegistrationProcess(@RequestBody UserRegisterCommandDto userRegisterCommandDto) {
    userFacade.performUserRegistrationProcess(userRegisterCommandDto);
    return null;
  }


}
