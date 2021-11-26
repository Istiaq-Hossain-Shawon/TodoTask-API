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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		piorityService.save(new Piority(1, "low"));
		piorityService.save(new Piority(2, "medium"));
		piorityService.save(new Piority(3, "high"));
    }
	@PostConstruct
    public void initTodoTask() throws Exception {
        todoTaskService.save(new TodoTaskDto(1, "Task 1",false,new Piority(1, "low")));;
        todoTaskService.save(new TodoTaskDto(2, "Task 2",false,new Piority(2, "medium")));;
        todoTaskService.save(new TodoTaskDto(3, "Task 3",false,new Piority(3, "high")));;
        todoTaskService.save(new TodoTaskDto(4, "Task 4",false,new Piority(1, "low")));;
        todoTaskService.save(new TodoTaskDto(5, "Task 5",false,new Piority(1, "low")));;
        
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TodotaskApplication.class, args);
	}

}
