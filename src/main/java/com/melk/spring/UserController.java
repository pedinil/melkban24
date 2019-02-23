package com.melk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.melk.spring.model.Users;

import com.melk.spring.service.UsersService;

@Controller
public class UserController {
	
	private UsersService usersService;
	
	@Autowired(required=true)
	@Qualifier(value="UsersService")
	public void setUsersService(UsersService ps){
		this.usersService = ps;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
	/*	model.addAttribute("user", new Users());
		model.addAttribute("listUsers", this.usersService.listUsers());
		return "users";*/
		
		return "home";
	}
	
	

	@RequestMapping(value = "/users/json", method = RequestMethod.GET)
	public  ResponseEntity<Users> getListUsers(Model model) {
	
		Users f=(Users)this.usersService.listUsers();
		
		  return new ResponseEntity<Users>(f, HttpStatus.OK);
	}
	
	
}
