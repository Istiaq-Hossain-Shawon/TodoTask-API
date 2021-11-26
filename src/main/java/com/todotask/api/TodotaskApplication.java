package com.todotask.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.User;
import com.todotask.api.repository.UserRepository;
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
	 
	@PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "user1", "123456", "user1@gmail.com"),
                new User(102, "user2", "654321", "user2@gmail.com")	                
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
	@PostConstruct
    public void initTodoTask() throws Exception {
        List<TodoTaskDto> locations = Stream.of(
                new TodoTaskDto(1, "Mohakhali, Dhaka, Bangladesh"),
                new TodoTaskDto(2, "Barisal District"),
                new TodoTaskDto(3, "Chittagong District"),
                new TodoTaskDto(4, "Comilla  District"),
                new TodoTaskDto(5, "Tangail  District")	  
        ).collect(Collectors.toList());
//        todoTaskService.saveAll(locations);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TodotaskApplication.class, args);
	}

}
