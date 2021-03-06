package org.auth.dao;

import org.auth.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
	
	public AppUser findByUsername(String username);
	
}
