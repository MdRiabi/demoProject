package com.component;

import com.model.User;
import com.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class LoadUsersInDB  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
     private PasswordEncoder passwordEncoder ;


    @Override
    public void run(String... args) throws Exception {

    	if (userRepository.count()>0) {
			return;
		}
        User user0 = new User("louay", UUID.randomUUID().toString() , "Med", "riabi", "23" , "tunis");
        User user1 = new User("userA", UUID.randomUUID().toString() , "zina", "ferchichi", "50", "paris");
        User user2 = new User("userB", UUID.randomUUID().toString() ,  "tarek", "riabi", "33", "italy");
        User user3 = new User("userC", UUID.randomUUID().toString() ,  "hamza", "riabi", "25", "germany");
        User user4 = new User("userD", UUID.randomUUID().toString() , "zina", "ferchichi", "50", "caire");
        User user5 = new User( "userE", UUID.randomUUID().toString() , "tarek", "riabi", "33", "madrid");
        User user6 = new User( "userF", UUID.randomUUID().toString() , "hamza", "riabi", "25", "munich");
        User user7 = new User("userG", UUID.randomUUID().toString() , "zina", "ferchichi", "50", "istanboul");
        User user8 = new User("userH", UUID.randomUUID().toString() ,  "tarek", "riabi", "33", "baghded");
        User user9 = new User("userI", UUID.randomUUID().toString() ,  "hamza", "riabi", "25", "new york");
        
        List<User> usersList = Arrays.asList(user0, user1, user2 , user3 , user4, user5, user6, user7, user8 , user9);
        
        usersList = usersList.stream().map(user -> {
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	return user;
        }).collect(Collectors.toList());
        
        
        userRepository.saveAll(usersList);
    }
}
