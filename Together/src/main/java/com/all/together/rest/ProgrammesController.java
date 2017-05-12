package com.all.together.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.ProgrammesRepository;
import com.all.together.model.ProgrammesModel;
import com.all.together.util.JavaUtil;

@RestController
@RequestMapping(value="/programs")
public class ProgrammesController {

	private ProgrammesRepository repo;
	
	@Autowired
	public ProgrammesController(ProgrammesRepository companyRepo) {
		super();
		this.repo = companyRepo;
	}
	   
	@RequestMapping(value = "/getPrograms", method=RequestMethod.GET)
	public ResponseEntity<List<ProgrammesModel>> getPrograms(){
		return new ResponseEntity<>( (List<ProgrammesModel>)repo.findAll(), HttpStatus.OK);
	}

	
   @RequestMapping(value = "/getProgramByName", method = RequestMethod.GET)
   public ResponseEntity<ProgrammesModel> getProgramByName(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> programData = JavaUtil.dissasambleJson(data);
      String name = programData.get("name");

      Long foundId = repo.getProgramId(name).get();
      if(foundId == null) {
         return new ResponseEntity<>(null, HttpStatus.OK);
      }
      ProgrammesModel model = repo.findOne(foundId);
      return new ResponseEntity<>(model, HttpStatus.OK);
   }
	
}