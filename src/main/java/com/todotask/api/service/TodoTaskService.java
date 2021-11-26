package com.todotask.api.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.todotask.api.config.exception.ResourceAlreadyExistsException;
import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.Piority;
import com.todotask.api.model.TotoTask;
import com.todotask.api.repository.PiorityRepository;
import com.todotask.api.repository.TodoTaskRepository;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
@Service
public class TodoTaskService {
	@Autowired
	private TodoTaskRepository todoTaskRepository;
	private PiorityRepository piorityRepository;
	public Page<TotoTask> getAll(Optional<Integer> page,Integer size ) {	
		return todoTaskRepository.findAll(PageRequest.of(page.orElse(0),size,Sort.by(Sort.Direction.DESC, "piority")));
	}
	public TotoTask findByDescription(String description) {
		return  todoTaskRepository.findByDescription(description);
	}

	public void save(TodoTaskDto taskDto) throws Exception {
		
		TotoTask check = todoTaskRepository.findByDescription(taskDto.getDescription());
		if (check == null) {
			var TotoTaskEntiry = new TotoTask();
			BeanUtils.copyProperties(taskDto, TotoTaskEntiry);
			Piority piority=piorityRepository.findById(taskDto.getPiorityId()).get();
			TotoTaskEntiry.setPiority(piority);
			todoTaskRepository.save(TotoTaskEntiry);
		} else {
			check.setDescription(taskDto.getDescription());
			todoTaskRepository.save(check);
		}
	}
}
