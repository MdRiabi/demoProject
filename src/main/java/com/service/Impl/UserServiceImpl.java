package com.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	
	public static List<User> userList = new ArrayList<>();
	public static Integer COUNTER = 0;
	
	static {
		User user = new User(COUNTER++, "Med","riabi","32","tunis");
		userList.add(user);
		
		new User(COUNTER++, "zina","ferchichi","50","tunis");
		userList.add(user);
		
		new User(COUNTER++, "tarek","riabi","33","tunis");
		userList.add(user);
		
		new User(COUNTER++, "hamza","riabi","25","tunis");
		userList.add(user);
		
	}
	
	

	@Override
	public List<User> findAll() {
		
		return userList;
	}

}
