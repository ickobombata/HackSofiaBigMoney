package com.all.together.dao;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.ScholarshipsModel;

import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(path = "scholarships")
public interface ScholarshipsRepository extends CrudRepository<ScholarshipsModel, Long>{

}
