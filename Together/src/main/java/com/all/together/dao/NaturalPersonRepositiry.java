package com.all.together.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.CompanyModel;
import com.all.together.model.NaturalPerson;

@RepositoryRestResource(path = "natural_person")
public interface NaturalPersonRepositiry extends CrudRepository<NaturalPerson, Long>{

   @Query("UPDATE NaturalPerson as n SET n.education = :education, n.sex = :sex, n.status = :status WHERE n.userId = :userId")
   @Modifying
   public void updatePerson(@Param("education") String education, 
         @Param("sex") String sex, 
         @Param("status") String status,
         @Param("userId") Long userId);
}
