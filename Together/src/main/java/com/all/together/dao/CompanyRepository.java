package com.all.together.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.CompanyModel;

@RepositoryRestResource(path = "companies")
public interface CompanyRepository extends CrudRepository<CompanyModel, Long>{


}
