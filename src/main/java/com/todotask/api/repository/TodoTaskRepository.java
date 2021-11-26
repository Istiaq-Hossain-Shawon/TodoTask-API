package com.todotask.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.todotask.api.model.TotoTask;
import com.todotask.api.model.User;


public interface TodoTaskRepository extends JpaRepository<TotoTask,Integer> {
	TotoTask findByDescription(String description);
	
}
