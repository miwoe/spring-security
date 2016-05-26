package de.miwoe.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.miwoe.model.User;
import de.miwoe.repository.UserRepository;

@Service
public class DBUserDetailsService implements UserDetailsService {

	@Autowired 
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(loginName);
		if (user == null) {
			throw new UsernameNotFoundException("Username " + loginName + " not found.");
		}
		
		return new org.springframework.security.core.userdetails.User(loginName, user.getPassword(), user.getUserRoles());
	}


}
