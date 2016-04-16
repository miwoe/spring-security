package de.miwoe.repository;

import org.springframework.data.repository.CrudRepository;

import de.miwoe.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	
	public User findByUsername(String username);
}
