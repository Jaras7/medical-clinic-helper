package com.medical.clinic.helper.user;

import com.medical.clinic.helper.user.dto.UserLoginQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
class UserLoginController {


  private final UserFacade userFacade;

  @Autowired
  UserLoginController (UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @RequestMapping(method = RequestMethod.POST)
  ResponseEntity<?> performLoginValidation(@RequestBody UserLoginQueryDto userLoginQueryDto) {
   // User userToValidate = userConverterDto.convert(userLoginQueryDto);
//    boolean result = userFacade.validateIfUserExistsByUsername(userToValidate);
//    if (!result) {
//      return new ResponseEntity<>(new UserErrorType("Wrong User/Password"), HttpStatus.UNAUTHORIZED);
//    }
//    return new ResponseEntity<>(userLoginQueryDto, HttpStatus.OK);
  return null;
 }


}
