package com.all.together.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.ProfilesRepository;
import com.all.together.model.ProfileModel;


@RestController
@RequestMapping(value="/profiles")
public class ProfilesControler {
	
	private ProfilesRepository profileRepo;

	@Autowired
	public ProfilesControler(ProfilesRepository profileRepo) {
		super();
		this.profileRepo = profileRepo;
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProfileModel>> getAllMembers(){
		return new ResponseEntity<>( (List<ProfileModel>)profileRepo.findAll(), HttpStatus.OK);
	}

}
