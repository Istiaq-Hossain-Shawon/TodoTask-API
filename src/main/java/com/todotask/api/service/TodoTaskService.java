package com.todotask.api.service;


import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todotask.api.config.exception.ResourceAlreadyExistsException;

import com.todotask.api.model.TotoTask;
import com.todotask.api.repository.TodoTaskRepository;

@Service
public class TodoTaskService {
	public List<TotoTask> getAll() {

		return todoTaskRepository.findAll();
	}

	@Autowired
	private TodoTaskRepository todoTaskRepository;
	
	
}
