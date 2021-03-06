package com.todotask.api.repository;

 
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todotask.api.model.Piority;


public interface PiorityRepository extends JpaRepository<Piority,Integer> {
	@Transactional
	Piority findByName(String name);
}
