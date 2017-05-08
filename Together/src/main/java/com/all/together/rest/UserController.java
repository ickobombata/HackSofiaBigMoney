package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.UserRepository;
import com.all.together.model.ProfileModel;
import com.all.together.model.UserModel;

@RestController
@RequestMapping(value="/users")
public class UserController {

	private UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserModel>> getAllUsers(){
		return new ResponseEntity<>( (List<UserModel>)userRepo.findAll(), HttpStatus.OK);
	}
	
}
