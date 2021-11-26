package com.todotask.api.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.todotask.api.model.Piority;

 


public interface PiorityRepository extends JpaRepository<Piority,Integer> {
	Piority findByName(String name);
	
}
