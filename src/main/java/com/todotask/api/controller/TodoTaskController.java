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
	public Page<TotoTask>  todoTask(@RequestParam(value = "page") Optional<Integer> page,@RequestParam(value = "size") Integer size) {
		Page<TotoTask> data=todoTaskService.getAll(page,size);
		return data;
	}	
	
	@PostMapping(value = "/saveTask")	
	public ResponseDTO beftnTransactionSingle(@RequestBody TodoTaskDto taskDTO, Principal principal)
	{
		try
		{
			todoTaskService.save(taskDTO);
			ResponseDTO responseDTO = TodoTaskUtil.createResponseSuccess();
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
