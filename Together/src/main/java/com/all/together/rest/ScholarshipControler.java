package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.ScholarshipsRepository;
import com.all.together.model.ScholarshipsModel;
import com.all.together.model.UserModel;
@RestController
@RequestMapping(value = "/scholarships")
public class ScholarshipControler {
	private ScholarshipsRepository repo;
	
	
	@Autowired
	public ScholarshipControler(ScholarshipsRepository repos) {
		super();
		// TODO Auto-generated constructor stub
		this.repo = repos;
	}
	
	   @RequestMapping(method = RequestMethod.GET)
	   public ResponseEntity<List<ScholarshipsModel>> getAllScholarship() {
	      return new ResponseEntity<>((List<ScholarshipsModel>) repo.findAll(),
	            HttpStatus.OK);
	   }
	
}
