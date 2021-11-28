package com.todotask.api.service;

import java.util.Optional;

import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.TodoTask;
import com.todotask.api.response.ResponseDTO;

public interface TodoTaskService {
	 ResponseDTO getAll(Optional<Integer> page,Integer size,Optional<Boolean> isDone ) ;
	 TodoTask findByDescription(String description);
	 ResponseDTO findById(int id);
	 ResponseDTO save(TodoTaskDto taskDto) ;
	 ResponseDTO update(TodoTaskDto taskDto);
	 ResponseDTO delete(TodoTaskDto taskDto);

}
