package com.all.together.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.ScholarshipsModel;

@RepositoryRestResource(path = "scholarships")
public interface ScholarshipsRepository
      extends CrudRepository<ScholarshipsModel, Long> {

   @Query("SELECT s FROM ScholarshipsModel s WHERE s.minBal < :minBal and s.mentFor like %:aa%")
   public Optional<List<ScholarshipsModel>> getScholshipsByBalProgram(
         @Param("minBal") double minBal, 
         @Param("aa") String aa);

   @Query("SELECT s FROM ScholarshipsModel s WHERE s.description like %:aa%")
   public Optional<List<ScholarshipsModel>> getScholshipsByDescription(
         @Param("aa") String string);
}