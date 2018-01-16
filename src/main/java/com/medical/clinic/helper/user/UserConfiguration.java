package com.medical.clinic.helper.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.medical.clinic.helper.user")
@Configuration
class UserConfiguration {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Autowired
   UserConfiguration(UserRepository userRepository, ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Bean
  UserFacade userFacade(UserRepository userRepository) {
    return new UserFacade(userRepository,modelMapper);
  }

}
