package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.CompanyRepository;
import com.all.together.model.CompanyModel;

@RestController
@RequestMapping(value="/companies")
public class CompanyController {
	
	private CompanyRepository repo;

	@Autowired
	public CompanyController(CompanyRepository repo) {
		super();
		this.repo = repo;
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CompanyModel>> getAllMembers(){
		return new ResponseEntity<>( (List<CompanyModel>)repo.findAll(), HttpStatus.OK);
	}

}
