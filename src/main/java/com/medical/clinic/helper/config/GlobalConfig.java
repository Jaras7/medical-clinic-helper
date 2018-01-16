package com.medical.clinic.helper.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GlobalConfig {

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
