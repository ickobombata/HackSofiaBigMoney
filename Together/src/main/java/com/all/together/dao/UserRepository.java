package com.all.together.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

import com.all.together.model.UserModel;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<UserModel, Long>{
   
   @Query("SELECT u.id  FROM UserModel u WHERE u.name = :name")
   public Optional<Long> getUserId(@Param("name") String name);
   
   
   @Query("SELECT u.password  FROM UserModel u WHERE u.name = :name and u.password = :password")
   public Optional<String> getUserPassword(@Param("name") String name, @Param("password") String password);
}
