package com.medical.clinic.helper.user;

import com.medical.clinic.helper.user.dto.UserRegisterCommandDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.stream.Stream;

public class UserFacade {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;


  @Autowired
  public UserFacade(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  public void createUser(User user) {
    userRepository.save(user);
  }

  public User getUserById(Long id) {
    return userRepository.findOne(id);
  }

  public Page<User> showUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  public boolean checkIfUserExistsByLogin(String login) {
    User userToValidate = userRepository.findUserByLogin(login);
    return userToValidate != null;
  }

  public ResponseEntity<?> performUserRegistrationProcess(UserRegisterCommandDto userRegisterCommandDto) {
    if (!checkIfUserExistsByLogin(userRegisterCommandDto.getLogin())) {
      User userToCreate = modelMapper.map(userRegisterCommandDto, User.class);
      userRepository.save(userToCreate);
      return new ResponseEntity<>(userRegisterCommandDto, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(new UserErrorType("Login already used"), HttpStatus.CONFLICT);
  }

}
