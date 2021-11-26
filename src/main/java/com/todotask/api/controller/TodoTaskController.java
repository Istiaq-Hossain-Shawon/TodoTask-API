package com.todotask.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todotask.api.model.TotoTask;
import com.todotask.api.service.TodoTaskService;


@RestController
public class TodoTaskController {
	
	 @Autowired
	 private TodoTaskService todoTaskService;
	 
	
	@GetMapping(value = "/todo-tasks")
	public Page<TotoTask>  todoTask(@RequestParam(value = "page") Optional<Integer> page,
            @RequestParam(value = "sortBy") Optional<String> sortBy) {
		Page<TotoTask> data=todoTaskService.getAll(page,sortBy);
		return data;
	}
	
	@GetMapping(value = {"/home"})
	public String  home() {
		
		return "Api is running.Please follow api documentation for next procedure. ";
	}


}
