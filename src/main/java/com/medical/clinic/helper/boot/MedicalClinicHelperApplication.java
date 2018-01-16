package com.medical.clinic.helper.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.medical.clinic")
@EntityScan(basePackages = "com.medical.clinic.helper")
@EnableJpaRepositories(basePackages = "com.medical.clinic.helper")
@SpringBootApplication
public class MedicalClinicHelperApplication {

  public static void main(String[] args) {
    SpringApplication.run(MedicalClinicHelperApplication.class, args);
  }
}
