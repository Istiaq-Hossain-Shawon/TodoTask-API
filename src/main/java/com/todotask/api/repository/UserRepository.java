package com.todotask.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todotask.api.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
