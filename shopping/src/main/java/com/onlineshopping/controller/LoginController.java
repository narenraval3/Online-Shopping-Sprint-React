package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.constant.Constant;
import com.onlineshopping.entity.Admin;
import com.onlineshopping.entity.Login;
import com.onlineshopping.entity.User;
import com.onlineshopping.exception.NoUserFoundException;
import com.onlineshopping.service.AdminService;
import com.onlineshopping.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

//	@Autowired
//	UserService userService;
//	@Autowired
//	AdminService adminService;
	
	


//	@PostMapping(value = "/user/loginProcess")
//	public String login(@RequestBody Login login) throws NoUserFoundException {
//
//		User user = userService.validateUser(login);
//
//		boolean isValidUser = false;
//
//		if (null != user) {
//			if ((user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword()))) {
//				isValidUser = true;
//			} else {
//
//				throw new NoUserFoundException();
//			}
//
//		}
//
//		return isValidUser ? Constant.SUCCESSFULLY_LOGGED_IN : Constant.LOGGED_IN_FAILED;
//	}
//	
//	@PostMapping(value = "/admin/login")
//	public String login(@RequestBody Login login) throws NoUserFoundException {
//		Admin admin = adminService.validateUser(login);
//
//		boolean isValidUser = false;
//
//		if (null != admin) {
//			if ((admin.getAdminName().equals(login.getAdminName())
//					&& admin.getPassword().equals(login.getPassword()))) {
//				isValidUser = true;
//			} else {
//				throw new NoUserFoundException();
//			}
//		}
//		return isValidUser ? Constant.SUCCESSFULLY_LOGGED_IN : Constant.LOGGED_IN_FAILED;
//	}
	

}
