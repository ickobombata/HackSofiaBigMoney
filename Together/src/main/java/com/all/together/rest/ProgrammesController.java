package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.ProgrammesRepository;
import com.all.together.model.ProgrammesModel;

@RestController
@RequestMapping(value="/programmes")
public class ProgrammesController {

	private ProgrammesRepository companyRepo;
	
	@Autowired
	public ProgrammesController(ProgrammesRepository companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}


	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProgrammesModel>> getAllUsers(){
		return new ResponseEntity<>( (List<ProgrammesModel>)companyRepo.findAll(), HttpStatus.OK);
	}
	
}