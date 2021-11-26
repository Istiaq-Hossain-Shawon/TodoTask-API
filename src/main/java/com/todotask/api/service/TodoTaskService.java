package com.todotask.api.service;


import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todotask.api.config.exception.ResourceAlreadyExistsException;
import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.TotoTask;
import com.todotask.api.repository.TodoTaskRepository;

@Service
public class TodoTaskService {
	@Autowired
	private TodoTaskRepository todoTaskRepository;
	public List<TotoTask> getAll() {
		return todoTaskRepository.findAll();
	}
	
	public void saveAll(List<TodoTaskDto> tasks) throws Exception {
		tasks.forEach(task -> {
			try {
				save(task);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	}
	private void save(TodoTaskDto taskDto) throws Exception {
		TotoTask check = todoTaskRepository.findByDescription(taskDto.getDescription());
		if (check == null) {
			var TotoTaskEntiry = new TotoTask();
			BeanUtils.copyProperties(taskDto, TotoTaskEntiry);
			TotoTaskEntiry.setId(taskDto.getId());
			todoTaskRepository.save(TotoTaskEntiry);
		} else {
			throw new ResourceAlreadyExistsException("This task already existed");
		}

	}

	
	
	
}
