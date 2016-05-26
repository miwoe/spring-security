package de.miwoe.repository;

import org.springframework.data.repository.CrudRepository;

import de.miwoe.model.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long>{

	public UserRole findOneByRole(String role);
}
