package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.NaturalPersonRepositiry;
import com.all.together.model.CompanyModel;
import com.all.together.model.NaturalPerson;

@RestController
@RequestMapping(value = "/natural_person")
public class NaturalPersonController {
	private NaturalPersonRepositiry repo;
	

	@Autowired
	public NaturalPersonController(NaturalPersonRepositiry repo) {
		super();
		this.repo = repo;
	}
	
	 @RequestMapping(method = RequestMethod.GET)
	 public ResponseEntity<List<NaturalPerson>> getAllNaturalPerson(){
		 return new ResponseEntity<>( (List<NaturalPerson>)repo.findAll(), HttpStatus.OK);
	 }
	

}
