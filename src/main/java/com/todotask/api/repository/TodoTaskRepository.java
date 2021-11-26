package com.todotask.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todotask.api.model.TotoTask;
import com.todotask.api.model.User;

@Transactional
@Repository
public interface TodoTaskRepository extends JpaRepository<TotoTask,Integer> {
	TotoTask findByDescription(String description);
	Page<TotoTask> findAll(Pageable pageable);
	
}
