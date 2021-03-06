package com.all.together.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
@RequestMapping(value = "/programs")
public class ProgrammesController {

   private ProgrammesRepository repo;
   private static final String DESCRIPTION = "description";

   @Autowired
   public ProgrammesController(ProgrammesRepository companyRepo) {
      super();
      this.repo = companyRepo;
   }

   @RequestMapping(value = "/getPrograms", method = RequestMethod.GET)
   public ResponseEntity<List<ProgrammesModel>> getPrograms() {
      return new ResponseEntity<>((List<ProgrammesModel>) repo.findAll(),
            HttpStatus.OK);
   }

   @RequestMapping(value = "/getProgramByName", produces = "application/json", method = RequestMethod.GET)
   public ResponseEntity<ProgrammesModel> getProgramByName(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> programData = JavaUtil.dissasambleJson(data);
      String name = programData.get("name");

      Long foundId = repo.getProgramId(name).get();
      if (foundId == null) {
         return new ResponseEntity<>(null, HttpStatus.OK);
      }
      ProgrammesModel model = repo.findOne(foundId);
      return new ResponseEntity<>(model, HttpStatus.OK);
   }

   @RequestMapping(value = "/getProgramsByDescription", produces = "application/json", method = RequestMethod.GET)
   public ResponseEntity<List<ProgrammesModel>> getPrograms(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> programData = JavaUtil.dissasambleJson(data);
      String des = programData.get(DESCRIPTION);
      Optional<List<ProgrammesModel>> getAllPrograms = repo
            .getAllProgramsByDesriptions(des);

      if (!getAllPrograms.isPresent()) {
         return null;
      }

      return new ResponseEntity<>(getAllPrograms.get(), HttpStatus.OK); // returnning
      // the user
      // data
   }
   
   @RequestMapping(value = "/getByField", produces = "application/json", method = RequestMethod.GET)
   public ResponseEntity<List<ProgrammesModel>> getAllByField (@RequestParam(value = "data", required= true)String data){
	   List<ProgrammesModel> prog = (List<ProgrammesModel>) repo.findAll();
	   List<ProgrammesModel> fil = new ArrayList<>();
	   for(ProgrammesModel model : prog){
		   if(model.getDescription().toLowerCase().contains(data.toLowerCase())){
			   fil.add(model);
		   }
	   }
	   
	   return new ResponseEntity<>(fil, HttpStatus.OK);
   }
   
}