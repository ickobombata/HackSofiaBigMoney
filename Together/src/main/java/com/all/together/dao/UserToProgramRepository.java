package com.all.together.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.all.together.model.UserToProgramModel;


@RepositoryRestResource(path = "user_tot_programs")
public interface UserToProgramRepository extends CrudRepository<UserToProgramModel, Long> {

	   @Query("SELECT u.program_id  FROM UserToProgramModel u WHERE u.user_id = :user_id and u.program_id IS NOT NULL")
	   public Optional<List<Long>> getAllProgramsForUser(@Param("user_id") Long user_id);
	   
	   @Query("SELECT u.schoolarship_id  FROM UserToProgramModel u WHERE u.user_id = :user_id and u.schoolarship_id IS NOT NULL")
	   public Optional<List<Long>> getAllSchoolarshipsForUser(@Param("user_id") Long user_id);
}
