package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsreController {
	
	@Autowired
	private UserService userService;
	@GetMapping
	public List<User> findAll(){
		
		return userService.findAll();
	}


    @GetMapping("/{id}")
    public  User findById(@PathVariable Long id){
        Optional<User> userOpt = userService.findById(id);
        if (userOpt.isPresent()){
            return  userOpt.get();
        }
        return null;
    }

}
