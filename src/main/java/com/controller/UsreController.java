package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UsreController {
	
	@Autowired
	private UserService userService;
	
	
	public List<User> findAll(){
		
		return userService.findAll();
	}

}
