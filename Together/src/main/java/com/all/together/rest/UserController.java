package com.all.together.rest;

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

import com.all.together.dao.CompanyRepository;
import com.all.together.dao.NaturalPersonRepositiry;
import com.all.together.dao.UserRepository;
import com.all.together.model.CompanyModel;
import com.all.together.model.NaturalPerson;
import com.all.together.model.UserModel;
import com.all.together.util.JavaUtil;
import com.all.together.util.SessionUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private UserRepository userRepo;
	private NaturalPersonRepositiry _naturalRepo;
	private CompanyRepository _companyRepo;
	private Gson _gson;
	private static final String ID = "id";

	private static final String BOSS = "boss";
	private static final String EMPLOYEE = "employee";
	private static final String FIELD = "field";
	private static final String EDUCATION = "education";
	private static final String SEX = "sex";
	private static final String STATUS = "status";
	private static final String COMPANY_USER = "company";
	private static final String NATURAL_USER = "natural";

	@Autowired
	public UserController(UserRepository userRepo, CompanyRepository companyRepo, NaturalPersonRepositiry naturalRepo) {
		super();
		this.userRepo = userRepo;
		this._companyRepo = companyRepo;
		this._naturalRepo = naturalRepo;
		_gson = new GsonBuilder().setDateFormat("dd-mm-yyyy").create();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserModel>> getAllUsers() {
		return new ResponseEntity<>((List<UserModel>) userRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserModel> signUp(@RequestParam(value = "data", required = true) String data) {
		HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
		String username = userData.get("username");
		String password = userData.get("password");
		String type = userData.get("type");

		Optional<List<Long>> userId = userRepo.getUserId(username);
		if (!userId.isPresent()) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		UserModel user = new UserModel();
		user.setId(new Long(1500));
		user.setName(username);
		user.setPassword(password);
		userRepo.save(user);
		Optional<List<Long>> userIdTxt = userRepo.getUserId(user.getName());
		if (!userIdTxt.isPresent()) {
			throw new RuntimeException("the user cou;d not be saved!");
		}

		if (type.equals(COMPANY_USER)) {
			CompanyModel companyModel = new CompanyModel(user.getId());
			companyModel.setUserId(userIdTxt.get().get(0));
			_companyRepo.save(companyModel);
		} else if (type.equals(NATURAL_USER)) {
			NaturalPerson naturalPerson = new NaturalPerson(user.getId());
			_naturalRepo.save(naturalPerson);
		} else {
			throw new IllegalArgumentException("missing type argument");
		}

		return new ResponseEntity<>(user, HttpStatus.OK); // we should return
															// Logged in Home
															// page.
	}

	@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<UserModel> login(@RequestParam(value = "data", required = true) String data) {
		HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
		String username = userData.get("username");
		String password = userData.get("password");

		Optional<List<Long>> foundUserId = userRepo.getUserId(username);

		if (!foundUserId.isPresent()) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}

		String foundUserPassword = userRepo.getUserPassword(username, password).get().get(0);
		if (foundUserId == null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		if (foundUserPassword == null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}

		SessionUtil.loginUser(username);
		UserModel foundUser = userRepo.findOne(foundUserId.get().get(0));
		if (foundUser.getPassword().equals(foundUserPassword)) {
			return new ResponseEntity<>(foundUser, HttpStatus.OK); // returnning
																	// the user
																	// data
		}
		return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(@RequestParam(value = "data", required = true) String data) {
		HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
		String username = userData.get("username");

		boolean success = SessionUtil.logoutUser(username);

		return new ResponseEntity<>("good", HttpStatus.OK); // return landing
															// page
	}

	@RequestMapping(value = "/getUserInfo", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<UserModel> getUserInfo(@RequestParam(value = "data", required = true) String data) {
		HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
		String username = userData.get("username");

		Optional<List<Long>> foundUserId = userRepo.getUserId(username);
		if (!foundUserId.isPresent()) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}

		UserModel userResult = userRepo.findOne(foundUserId.get().get(0));

		CompanyModel cm = _companyRepo.findOne(userResult.getId());
		if (cm != null) {
			userResult.setCompany(cm);
		} else {
			NaturalPerson np = _naturalRepo.findOne(userResult.getId());
			userResult.setPerson(np);
		}

		return new ResponseEntity<>(userResult, HttpStatus.OK);
	}

	@RequestMapping(value = "update", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<UserModel> updateUser(@RequestParam(value = "data", required = true) String data) {
		HashMap<String, String> userData = JavaUtil.dissasambleJson(data);
		UserModel user = _gson.fromJson(data, UserModel.class);

		String type = userData.get("type");

		if (type.equals(COMPANY_USER)) {

		} else if (type.equals(NATURAL_USER)) {
			CompanyModel companyModel = new CompanyModel(new Long(1), new Long(userData.get(EMPLOYEE)), user.getId(),
					userData.get(BOSS), userData.get(FIELD));
			Optional<List<Long>> id = _companyRepo.getCompanyId(userData.get(ID));
			if (!id.isPresent()) {
				throw new IllegalStateException("cant miss company repo id for " + userData.get(ID));
			}
			companyModel.setId(id.get().get(0));
			_companyRepo.save(companyModel);
		} else {
			NaturalPerson naturalPerson = new NaturalPerson(new Long(1), userData.get(STATUS), user.getId(),
					userData.get(SEX), userData.get(EDUCATION));
			Optional<List<Long>> id = _naturalRepo.getNaturalId(userData.get(ID));
			if (!id.isPresent()) {
				throw new IllegalStateException("cant miss company repo id for " + userData.get(ID));
			}
			naturalPerson.setId(id.get().get(0));
			_naturalRepo.save(naturalPerson);
		}

		userRepo.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "INDEX PAGE";
	}
}
