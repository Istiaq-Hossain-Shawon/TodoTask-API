package com.todotask.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todotask.api.model.TotoTask;
import com.todotask.api.service.TodoTaskService;





@RestController
public class TodoTaskController {
	
	 @Autowired
	 private TodoTaskService todoTaskService;
	 
	
	@GetMapping(value = "/todo-tasks")
	public List<TotoTask>  todoTask() {
		List<TotoTask> data=todoTaskService.getAll();
		return data;
	}
	
	@GetMapping(value = {"/home"})
	public String  home() {
		
		return "Api is running.Please follow api documentation for next procedure. ";
	}





}
