package com.todotask.api.controller;

import java.security.Principal;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todotask.api.config.util.TodoTaskUtil;
import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.TotoTask;
import com.todotask.api.response.ResponseDTO;
import com.todotask.api.service.TodoTaskService;

@RestController
public class TodoTaskController {
	
	 @Autowired
	 private TodoTaskService todoTaskService;
	 private final Logger logger = LoggerFactory.getLogger(TodoTaskController.class);
	
	@GetMapping(value = "/todoTasks")
	public Page<TotoTask>  todoTask(@RequestParam(value = "page") Optional<Integer> page,@RequestParam(value = "size") Integer size,
			@RequestParam(value = "isDone") Optional<Boolean> isDone) {
		Page<TotoTask> data=todoTaskService.getAll(page,size,isDone);
		return data;
	}	
	
	@PostMapping(value = "/saveTask")	
	public ResponseDTO saveTask(@RequestBody TodoTaskDto taskDTO)
	{
		if(TodoTaskUtil.checkIfNull(taskDTO.getDescription())) {
			logger.error("Description is mendatory.");			
			return TodoTaskUtil.createResponseFalied("Description is mendatory.");
		}
		if(TodoTaskUtil.checkIfNull(taskDTO.getPiorityName())) {
			logger.error("Piority Name is mendatory.");			
			return TodoTaskUtil.createResponseFalied("Piority Name is mendatory.");
		}
		if((taskDTO.getIsDone())==null) {
			logger.error("Task status is mendatory.");			
			return TodoTaskUtil.createResponseFalied("Task status is mendatory.");
		}
		
		try
		{
			ResponseDTO responseDTO = todoTaskService.save(taskDTO);
			return responseDTO;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			return TodoTaskUtil.createResponseFalied(e.getMessage());
		}
	}
	@PostMapping(value = "/deleteTask")	
	public ResponseDTO deleteTask(@RequestBody TodoTaskDto taskDTO)
	{
		if(taskDTO.getId()==0) {
			logger.error("Task Id  is invalid.");			
			return TodoTaskUtil.createResponseFalied("Task Id  is invalid.");
		}		
		
		try
		{
			ResponseDTO responseDTO = todoTaskService.delete(taskDTO);
			return responseDTO;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			return TodoTaskUtil.createResponseFalied(e.getMessage());
		}
	}
	
	
	@GetMapping(value = {"/home"})
	public String  home() {
		return "Api is running.Please follow api documentation for next procedure. ";
	}


}
