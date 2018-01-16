package com.medical.clinic.helper.user;

import com.medical.clinic.helper.user.dto.UserRegisterCommandDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

  public boolean validateIfUserExistsByUsername(User user) {
    User userToValidate = userRepository.findUserByLogin(user.getLogin());
    return Optional.ofNullable(userToValidate).
        map(result -> userToValidate.getPassword().equals(user.getPassword()))
        .orElse(false);
  }

  public boolean performUserRegistrationProcess(UserRegisterCommandDto userRegisterCommandDto){
    User userToValidate = userRepository.findUserByLogin(userRegisterCommandDto.getLogin());
    Optional<User> userToCreate  = Stream.of(userRegisterCommandDto)
        .map(map->modelMapper.map(userRegisterCommandDto,User.class))
        .findFirst();
  userRepository.save(userToCreate.get());
  return true;
  }
}
