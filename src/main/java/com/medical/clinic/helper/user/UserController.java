package com.medical.clinic.helper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
class UserController {

  private final UserFacade userFacade;

  @Autowired
  UserController(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  Page<User> getAllUsers(Pageable pageable) {
    return userFacade.showUsers(pageable);
  }

  @RequestMapping(value = "createUser", method = RequestMethod.POST)
  ResponseEntity<String> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
    userFacade.createUser(user);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(uriComponentsBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
  ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    User user = userFacade.getUserById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
