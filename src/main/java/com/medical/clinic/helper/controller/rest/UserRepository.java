package com.medical.clinic.helper.controller.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
interface UserRepository extends JpaRepository<User, Long> {
  @Override
  User findOne(@Param("id") Long id);
}
