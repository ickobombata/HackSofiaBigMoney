package com.all.together.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.ProgrammesModel;

@RepositoryRestResource(path = "programmes")
public interface ProgrammesRepository extends CrudRepository<ProgrammesModel, Long> {

}
