package de.miwoe.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.miwoe.model.User;
import de.miwoe.model.UserRole;
import de.miwoe.repository.UserRepository;
import de.miwoe.repository.UserRoleRepository;

@RestController
public class RegisterController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@RequestMapping(value= "/registeruser", method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		Collection<UserRole>  userRoles = new ArrayList<>();
		UserRole userRole = new UserRole();
		userRole.setRole("IAMGROOT");
		userRoles.add(userRole);
		userRole.setUser(user);
		user.setUserRoles(userRoles);
		User persistedUser = userRepository.save(user);
		
		return persistedUser;
	}
	
	@RequestMapping(value= "/registeruser", method = RequestMethod.GET)
	public @ResponseBody User getUser() {
		
		User persistedUser = new User();
		
		return persistedUser;
	}
}
