package com.all.together.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.CompanyModel;

@RepositoryRestResource(path = "companies")
public interface CompanyRepository extends CrudRepository<CompanyModel, Long>{

}
