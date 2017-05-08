package com.all.together.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.AdminModel;
import com.all.together.model.ProfileModel;

@RepositoryRestResource(path = "admins")
public interface AdminRepository extends CrudRepository<AdminModel, Long>{


}
