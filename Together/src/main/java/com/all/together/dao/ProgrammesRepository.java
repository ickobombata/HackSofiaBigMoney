package com.all.together.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.ProgrammesModel;

@RepositoryRestResource(path = "programs")
public interface ProgrammesRepository extends CrudRepository<ProgrammesModel, Long> {

   @Query("SELECT u.id  FROM ProgrammesModel u WHERE u.name = :name")
   public Optional<Long> getProgramId(@Param("name") String name);
   
   @Query("SELECT u  FROM ProgrammesModel u WHERE u.description LIKE %:description%")
   public Optional<List<ProgrammesModel>> getAllProgramsByDesriptions(@Param("description") String description);
   

}