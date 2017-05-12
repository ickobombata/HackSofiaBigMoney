package com.all.together.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.all.together.dao.UserToProgramRepository;
import com.all.together.model.UserModel;
import com.all.together.model.UserToProgramModel;
import com.all.together.util.JavaUtil;
import com.all.together.util.SessionUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/watched")
public class UserToProgramController {
	private UserToProgramRepository repo;
	private Gson _gson;
	
	@Autowired
	public UserToProgramController(UserToProgramRepository repo) {
		super();
		this.repo = repo;
		_gson = new GsonBuilder().setDateFormat("dd-mm-yyyy").create();
	}

	public UserToProgramRepository getRepo() {
		return repo;
	}

	public void setRepo(UserToProgramRepository repo) {
		this.repo = repo;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<UserToProgramModel>> getAllUserToPrograms() {
	   return new ResponseEntity<>((List<UserToProgramModel>) repo.findAll(),
	         HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addwatch", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserToProgramModel> insertWatch(
	   @RequestParam(value = "data", required = true) String data) {
	   UserToProgramModel model = _gson.fromJson(data, UserToProgramModel.class);
	      
	   UserToProgramModel exists = repo.findOne(model.getId());
	   
	   System.out.println("ID: " + model.getId());
	      
	   if(exists != null) {
	      return new ResponseEntity<>(null, HttpStatus.OK);
	   }
	   repo.save(model);
	      return new ResponseEntity<>(model, HttpStatus.OK); 
	   }
	
	   @RequestMapping(value = "/getprograms" ,produces = "application/json", method = RequestMethod.GET)
	   public ResponseEntity<List<Long>> getPrograms(
	         @RequestParam(value = "data", required = true) Long user_id) {
		  
		  List<Long> getAllPrograms = repo.getAllProgramsForUser(user_id).get();

	      return new ResponseEntity<>(getAllPrograms, HttpStatus.OK);  // returnning the user data

	   }
	   
	   @RequestMapping(value = "/getschoolarships" ,produces = "application/json", method = RequestMethod.GET)
	   public ResponseEntity<List<Long>> getSchoolarships(
	         @RequestParam(value = "data", required = true) Long user_id) {
		  
		  List<Long> getAllSchoolarships = repo.getAllSchoolarshipsForUser(user_id).get();

	      return new ResponseEntity<>(getAllSchoolarships, HttpStatus.OK);  // returnning the user data

	   }

	
	

}
