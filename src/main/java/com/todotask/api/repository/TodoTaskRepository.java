package com.todotask.api.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todotask.api.model.TodoTask;


@Transactional
@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask,Integer> {
	List<TodoTask> findByDescription(String description);
	Page<TodoTask> findAll(Pageable pageable);
	Page<TodoTask> findByIsDone(Optional<Boolean> isDone,Pageable pageable);
	void saveAndFlush(Optional<TodoTask> check);
	
	
}
