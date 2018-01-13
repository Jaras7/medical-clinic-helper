package com.medical.clinic.helper.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicalCare")
class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/users",method = RequestMethod.GET)
  List getAllUsers(){
    return userRepository.findAll();
  }

  @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
  ResponseEntity<?> getUser(@PathVariable("id") Long id) {
    User user = userRepository.findOne(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
