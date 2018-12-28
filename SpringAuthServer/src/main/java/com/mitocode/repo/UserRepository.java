package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}