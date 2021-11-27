package com.todotask.api.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todotask.api.model.TotoTask;


@Transactional
@Repository
public interface TodoTaskRepository extends JpaRepository<TotoTask,Integer> {
	TotoTask findByDescription(String description);
	Page<TotoTask> findAll(Pageable pageable);
	Page<TotoTask> findByIsDone(Optional<Boolean> isDone,Pageable pageable);
	void saveAndFlush(Optional<TotoTask> check);
	
	
}
