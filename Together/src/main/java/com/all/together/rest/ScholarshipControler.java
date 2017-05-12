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

import com.all.together.dao.ScholarshipsRepository;
import com.all.together.model.ScholarshipsModel;
import com.all.together.util.JavaUtil;

@RestController
@RequestMapping(value = "/scholarships")
public class ScholarshipControler {
   private ScholarshipsRepository repo;

   private static final String DESCRIPTION = "description";

   private static final String MIN_BAL = "minBal";
   private static final String MENT_FOR = "mentFor";

   @Autowired
   public ScholarshipControler(ScholarshipsRepository repos) {
      super();
      // TODO Auto-generated constructor stub
      this.repo = repos;
   }

   @RequestMapping(method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<List<ScholarshipsModel>> getAllScholarship() {
      return new ResponseEntity<>((List<ScholarshipsModel>) repo.findAll(),
            HttpStatus.OK);
   }

   @RequestMapping(value = "/getScholarshipsByBalAndProgram", method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<List<ScholarshipsModel>> getScholarshipsByBalProgram(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> scholarship = JavaUtil.dissasambleJson(data);

      Optional<List<ScholarshipsModel>> scholarships = repo.getScholshipsByBalProgram(
            new Double(scholarship.get(MIN_BAL)), scholarship.get(MENT_FOR));

      if(scholarships.isPresent()) {
         return new ResponseEntity<>(scholarships.get(), HttpStatus.OK);
      }
      
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
   }

   @RequestMapping(value = "/getScholarshipsByDescription", method = RequestMethod.GET, produces = "application/json")
   public ResponseEntity<List<ScholarshipsModel>> getScholarshipsByDescription(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> scholarship = JavaUtil.dissasambleJson(data);

      Optional<List<ScholarshipsModel>> scholarships = repo.getScholshipsByDescription(
            scholarship.get(DESCRIPTION));

      if(scholarships.isPresent()) {
         return new ResponseEntity<>(scholarships.get(), HttpStatus.OK);
      }
      
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
   }
}
