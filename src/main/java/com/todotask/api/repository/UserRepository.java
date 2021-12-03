package com.todotask.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todotask.api.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	@Transactional
	User findByUserName(String username);
}
