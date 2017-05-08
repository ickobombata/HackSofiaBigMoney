package com.all.together.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.all.together.model.UserModel;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<UserModel, Long>{

}
