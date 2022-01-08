package com.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.constant.Constant;
import com.onlineshopping.dao.AdminDao;
import com.onlineshopping.dao.ProductDAO;
import com.onlineshopping.dao.UserDAO;
import com.onlineshopping.dto.UserDTO;
import com.onlineshopping.dto.UserDetailsRequestModel;
import com.onlineshopping.dto.UserRest;
import com.onlineshopping.entity.Login;
import com.onlineshopping.entity.OperationStatusModel;
import com.onlineshopping.entity.Product;
import com.onlineshopping.entity.User;
import com.onlineshopping.exception.EmailException;
import com.onlineshopping.exception.NoUserFoundException;
import com.onlineshopping.exception.RecordAlreadyExistException;
import com.onlineshopping.service.AdminService;
import com.onlineshopping.service.ProductService;
import com.onlineshopping.service.UserService;
import com.onlineshopping.service.UserServiceImpl;
import com.onlineshopping.utils.ErrorMessages;
//import com.onlineshopping.utils.ErrorMessages;
import com.onlineshopping.utils.RequestOperationName;
import com.onlineshopping.utils.RequestOperationResult;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
//	@Autowired
//	AdminService adminService;
//	
//	@Autowired
//	AdminDao adminDao;
//	
//	@Autowired
//	Admin admin;

	@Autowired
	UserDAO userdao;
	@Autowired
	ProductDAO productdao;
	@Autowired
	ProductService productService;
	
	@GetMapping("getUserByName/{userName}")
	public User getUserDetails(@PathVariable("userName")String userName) {
		
		return userdao.findByUsername(userName);
	
	}
	

	@PostMapping("/user/registration")
	public String addUser(@RequestBody User user) {
		Boolean userExist=Boolean.TRUE.equals(userdao.findByUserEmail(user.getUserEmail()));
		
		
		if (user.getUserEmail().isEmpty() || user.getUserEmail().isBlank()
				|| !user.getUserEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			throw new EmailException(Constant.MISSING_REQUIRED_FIELDS);
		}
		
		
		else if(userExist) {
			return Constant.RECORD_ALREADY_EXIST;
		}

		else {
			Boolean isUserAdded;
			try {
				
				isUserAdded = userService.userRegister(user);
				if (Boolean.TRUE.equals(isUserAdded)) {
					return Constant.USER_REGISTERED_SUCCESSFULLY;
				} 
				return Constant.UNABLE_TO_REGISTER;
			} catch (RecordAlreadyExistException ex) {
				throw new RecordAlreadyExistException(ErrorMessages.RECORD_ALREADY_EXIST.getErrorMessage());
			}

		}
	}

	@PostMapping(value = "/user/loginpage")
	public String login(@RequestBody Login login) throws NoUserFoundException {

		User user = userService.validateUser(login);

		boolean isValidUser = false;

		if (null != user) {
			if ((user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword()))) {
				isValidUser = true;
			} else {
				
				 throw new NoUserFoundException();
			}

		}

		return isValidUser ? Constant.SUCCESSFULLY_LOGGED_IN : Constant.LOGGED_IN_FAILED;
	}


	@PutMapping(path = "/userupdate/{userId}")
	public UserRest updateUser(@PathVariable("userId") String userId, @RequestBody UserDetailsRequestModel userDetails)
			throws NoUserFoundException {
		if (userDetails.getUserEmail().isEmpty()) {
			throw new NoUserFoundException(Constant.MISSING_REQUIRED_FIELDS);
		}

		UserRest userRest = new UserRest();

		UserDTO userDTO = new UserDTO();
//		BeanUtils.copyProperties(userDetails, userDTO);

		UserDTO updatedUserDTO = userService.updateUser(userId, userDTO);
		BeanUtils.copyProperties(updatedUserDTO, userRest);
		return userRest;
	}

	@DeleteMapping(path = "/{userName}")
	public OperationStatusModel deleteUser(@PathVariable("userName") String userName) {
		OperationStatusModel operationStatusModel = new OperationStatusModel();
		operationStatusModel.setOperationName(RequestOperationName.DELETE.name());

		userService.deleteUser(userName);

		operationStatusModel.setOperationResult(RequestOperationResult.SUCCESS.name());
		return operationStatusModel;
	}
	
//	@PostMapping("/user/registration")
//	public String addUser(@RequestBody User user) {
//
//		if (user.getUserEmail().isEmpty() || user.getUserEmail().isBlank()
//				|| !user.getUserEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
//			throw new EmailException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
//		}
//
//		else {
//			Boolean isUserAdded;
//			try {
//				isUserAdded = userService.userRegister(user);
//				if (isUserAdded) {
//					return "User Registered Successfully!!...";
//				} else {
//					return "Unable to Register User!!...";
//				}
//			} catch (RecordAlreadyExistException ex) {
//				throw new RecordAlreadyExistException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
//			}
//		}
//	}
}
