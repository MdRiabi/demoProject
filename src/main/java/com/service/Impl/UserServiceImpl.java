package com.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	
	public static List<User> userList = new ArrayList<>();
	public static long COUNTER ;
	
	static {
		User user = new User(COUNTER++, "Med","riabi","32","tunis");
		userList.add(user);

		User user1 =new User(COUNTER++, "zina","ferchichi","50","tunis");
		userList.add(user1);

		User user2 =new User(COUNTER++, "tarek","riabi","33","tunis");
		userList.add(user2);

		User user3 =new User(COUNTER++, "hamza","riabi","25","tunis");
		userList.add(user3);
		
	}

	@Override
	public List<User> findAll() {
		
		return userList;
	}

	@Override
	public Optional<User> findById(Long id) {

		return   userList.stream().filter(user -> user.getId() == id).findFirst();

//		 if (userOpt.isPresent()){
//			return  userOpt;
//		 }
//		 return  Optional.empty();
	}
}
