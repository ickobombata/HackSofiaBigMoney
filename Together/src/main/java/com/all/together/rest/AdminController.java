package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.AdminRepository;
import com.all.together.model.AdminModel;

@RestController
@RequestMapping(value="/admins")
public class AdminController {
	
	private AdminRepository repo;

	@Autowired
	public AdminController(AdminRepository repo) {
		super();
		this.repo = repo;
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AdminModel>> getAllMembers(){
		return new ResponseEntity<>( (List<AdminModel>)repo.findAll(), HttpStatus.OK);
	}

}
