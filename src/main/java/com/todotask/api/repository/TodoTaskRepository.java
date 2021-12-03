package com.todotask.api.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.todotask.api.model.TodoTask;

public interface TodoTaskRepository extends JpaRepository<TodoTask,Integer> {
	@Transactional
	List<TodoTask> findByDescription(String description);
	@Transactional
	Page<TodoTask> findAll(Pageable pageable);
	@Transactional
	Page<TodoTask> findByIsDone(Optional<Boolean> isDone,Pageable pageable);
	@Transactional
	void saveAndFlush(Optional<TodoTask> check);
	
	
}
