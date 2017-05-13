package com.all.together.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.all.together.model.CompanyModel;

@RepositoryRestResource(path = "companies")
public interface CompanyRepository extends CrudRepository<CompanyModel, Long>{

   @Query("UPDATE CompanyModel as c SET c.boss = :boss, c.employee = :employee, c.field = :field WHERE c.userId = :userId")
   @Modifying
   public void updateCompnay(@Param("boss") String boss,
         @Param("employee") Long employee,
         @Param("field") String field,
         @Param("userId") Long userId);
   
   @Query("SELECT u.id  FROM CompanyModel as u WHERE u.userId = :userId")
   public Optional<List<Long>> getCompanyId(@Param("userId") String userId);
}
