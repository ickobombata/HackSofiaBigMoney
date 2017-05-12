package com.all.together.rest;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.all.together.dao.UserRepository;
import com.all.together.model.UserModel;
import com.all.together.util.JavaUtil;
import com.all.together.util.SessionUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserController {

   private UserRepository userRepo;
   private Gson _gson;

   @Autowired
   public UserController(UserRepository userRepo) {
      super();
      this.userRepo = userRepo;
      _gson = new GsonBuilder().setDateFormat("dd-mm-yyyy").create();
   }

   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<List<UserModel>> getAllUsers() {
      return new ResponseEntity<>((List<UserModel>) userRepo.findAll(),
            HttpStatus.OK);
   }

   @RequestMapping(value = "/signup", method = RequestMethod.GET)
   public ResponseEntity<UserModel> signUp(
         @RequestParam(value = "data", required = true) String data) {
      UserModel user = _gson.fromJson(data, UserModel.class);
      
      UserModel exists = userRepo.findOne(user.getId());

      if(exists != null) {
         return new ResponseEntity<>(null, HttpStatus.OK);
      }
      userRepo.save(user);
      return new ResponseEntity<>(user, HttpStatus.OK); // we should return
                                                        // Logged in Home page.
   }

   @RequestMapping(value = "/login" ,produces = "application/json", method = RequestMethod.GET)
   public ResponseEntity<UserModel> login(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
      String username = userData.get("username");
      String password = userData.get("password");

      Long foundUserId = userRepo.getUserId(username).get();
      String foundUserPassword = userRepo.getUserPassword(username, password).get();
      if(foundUserId == null) {
         return new ResponseEntity<>(null, HttpStatus.OK);
      }
      if(foundUserPassword == null) {
          return new ResponseEntity<>(null, HttpStatus.OK);
       }
       
      
      SessionUtil.loginUser(username);
      UserModel foundUser = userRepo.findOne(foundUserId);
      if(foundUser.getPassword().equals(foundUserPassword)){
          return new ResponseEntity<>(foundUser, HttpStatus.OK);  // returnning the user data
      }
      
      return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
   }

   @RequestMapping(value = "/logout", method = RequestMethod.GET)
   public ResponseEntity<String> logout(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
      String username = userData.get("username");

      boolean success = SessionUtil.logoutUser(username);

      return new ResponseEntity<>("good", HttpStatus.OK); // return landing page
   }

   @RequestMapping(value = "/getUserInfo",produces = "application/json", method = RequestMethod.GET)
   public ResponseEntity<UserModel> getUserInfo(
         @RequestParam(value = "data", required = true) String data) {
      HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
      String username = userData.get("username");
      
      Long foundUserId = userRepo.getUserId(username).get();
      if(foundUserId == null) {
         return new ResponseEntity<>(null, HttpStatus.OK);
      }
      UserModel userResult = userRepo.findOne(foundUserId);
      return new ResponseEntity<>(userResult, HttpStatus.OK);
   }
   
   @RequestMapping(value = "/index")
   public String index() {
      return "INDEX PAGE";
   }
}
