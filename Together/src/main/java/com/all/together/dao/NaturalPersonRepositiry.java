package com.all.together.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.CompanyModel;
import com.all.together.model.NaturalPerson;

@RepositoryRestResource(path = "natural_person")
public interface NaturalPersonRepositiry extends CrudRepository<NaturalPerson, Long>{

}
