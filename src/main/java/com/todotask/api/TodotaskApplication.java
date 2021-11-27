package com.todotask.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.Piority;
import com.todotask.api.model.User;
import com.todotask.api.repository.UserRepository;
import com.todotask.api.service.PiorityService;
import com.todotask.api.service.TodoTaskService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class TodotaskApplication {

	@Autowired
	private UserRepository repository;
	 
	@Autowired
	private TodoTaskService todoTaskService;
	@Autowired
	private PiorityService piorityService;
	@PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "user1", "123456", "user1@gmail.com"),
                new User(102, "user2", "654321", "user2@gmail.com")	                
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
	@PostConstruct
    public void initPiority() throws Exception {
		if(piorityService.getPiorityByName("low")==null) {
			piorityService.save(new Piority(1, "low"));
		}
		if(piorityService.getPiorityByName("medium")==null) {
			piorityService.save(new Piority(2, "medium"));
		}
		if(piorityService.getPiorityByName("high")==null) {
			piorityService.save(new Piority(3, "high"));
		}
    }
	@PostConstruct
    public void initTodoTask() throws Exception {
		if(todoTaskService.findByDescription("Task 1")==null) {
			todoTaskService.save(new TodoTaskDto(1, "Task 1",false,"low","user1"));
		}
		if(todoTaskService.findByDescription("Task 2")==null) {
			 todoTaskService.save(new TodoTaskDto(2, "Task 2",false,"high","user1"));
		}
		if(todoTaskService.findByDescription("Task 3")==null) {
			todoTaskService.save(new TodoTaskDto(3, "Task 3",false,"low","user2"));;
		}
		if(todoTaskService.findByDescription("Task 4")==null) {
			todoTaskService.save(new TodoTaskDto(4, "Task 4",false,"medium","user2"));;
		}
		if(todoTaskService.findByDescription("Task 5")==null) {
			todoTaskService.save(new TodoTaskDto(5, "Task 5",false,"high","user1"));;
		}        
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TodotaskApplication.class, args);
	}

}
