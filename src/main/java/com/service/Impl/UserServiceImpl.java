package com.service.Impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	public static List<User> userList = new ArrayList<>();
//	public static long COUNTER;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

//	static {
//		User user = new User(COUNTER++, "Med", "riabi", "32", "tunis");
//		userList.add(user);
//
//		User user1 = new User(COUNTER++, "zina", "ferchichi", "50", "tunis");
//		userList.add(user1);
//
//		User user2 = new User(COUNTER++, "tarek", "riabi", "33", "tunis");
//		userList.add(user2);
//
//		User user3 = new User(COUNTER++, "hamza", "riabi", "25", "tunis");
//		userList.add(user3);
//
//	}

	@Override
	public List<User> findAll() {

		return  userRepository.findAll();
		//return userList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
	}

	@Override
	public Optional<User> findById(Long id) {

		return userRepository.findById(id);
		//return userList.stream().filter(user -> user.getId() == id).findFirst();

//		 if (userOpt.isPresent()){
//			return  userOpt;
//		 }
//		 return  Optional.empty();
	}

	@Override
	public void add(User user) {
		//user.setId(COUNTER++);
		//userList.add(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public Optional<User> update(User user) {
	//	Optional<User> userOpt = userList.stream().filter(u -> u.getId() == user.getId()).findFirst();
		Optional<User> userOpt = userRepository.findById(user.getId());

		if (userOpt.isPresent()) {
			User existingUser = userOpt.get();

			if (user.getFirstName() != null) {
				existingUser.setFirstName(user.getFirstName());
			}
			
			if (user.getUserName() != null) {
				existingUser.setUserName(user.getUserName());
			}

			
			if (user.getPassword() != null) {
				existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
			}


			if (user.getLastName() != null) {
				existingUser.setLastName(user.getLastName());

			}

			if (user.getAge() != null) {
				existingUser.setAge(user.getAge());

			}

			if (user.getCountry() != null) {
				existingUser.setCountry(user.getCountry());

			}
			// for removing the id of the user to updated
			//userList = userList.stream().filter(u -> u.getId() != existingUser.getId()).collect(Collectors.toList());

			userRepository.save(existingUser) ;
			// after removing the current user we add the updated user existingUser
			//userList.add(existingUser);

			return Optional.of(existingUser);

		}
		// if the user don't exist in listUser
		return Optional.empty();
	}
	@Override
	public Optional<User> delete(Long id) {

		//Optional<User> userOpt = userList.stream().filter(user -> user.getId() == id).findFirst();

		Optional<User> optUser = userRepository.findById(id);

		if (optUser.isPresent()) {
//			userList = userList.stream().filter(user -> userOpt.get().getId() != user.getId())
//					.collect(Collectors.toList());
			userRepository.delete(optUser.get());
			return optUser;
		}
		return Optional.empty();
	}

}
