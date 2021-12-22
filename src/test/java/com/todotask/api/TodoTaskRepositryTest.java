package com.todotask.api;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.todotask.api.model.Piority;
import com.todotask.api.model.TodoTask;
import com.todotask.api.repository.PiorityRepository;
import com.todotask.api.repository.TodoTaskRepository;
import org.junit.jupiter.api.MethodOrderer;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoTaskRepositryTest {
	    @Autowired
	    private TodoTaskRepository todoTaskRepository;
	    
	    @Autowired
	    private PiorityRepository piorityRepository;

	 // JUnit test for savePiority
	    @Test
	    @Order(1)
	    @Rollback(value = false)
	    void savePiorityTest(){
	    	Piority piority =new Piority();
	    	piority.setPiorityId(1);
	    	piority.setName("low");
	    	piorityRepository.save(piority);
	        Assertions.assertThat(piority.getPiorityId()).isPositive();
	    }
	    
	    // JUnit test for saveTodoTask
	    @Test
	    @Order(2)
	    @Rollback(value = false)
	    void saveTodoTaskTest(){

	    	TodoTask todoTask =new TodoTask();	    	
	    	todoTask.setDescription("Task 123");
	    	todoTask.setIsDone(false);
	    	todoTask.setPiority(piorityRepository.findByName("low"));
	    	todoTask.setCreatedBy("user1");
	    	todoTaskRepository.save(todoTask);
	        Assertions.assertThat(todoTask.getId()).isPositive();
	    }
	 // JUnit test for get single task by id
	    @Test
	    @Order(3)
	    void getTodoTaskTest(){

	    	TodoTask todoTask = todoTaskRepository.findById(1).get();

	        Assertions.assertThat(todoTask.getId()).isEqualTo(1);

	    }
	 // JUnit test for get all task list
	    @Test
	    @Order(4)
	    void getListOfTaskTest(){

	        List<TodoTask> todoTasks = todoTaskRepository.findAll();	        

	        Assertions.assertThat(todoTasks.size()).isPositive();

	    }
	    
	 // JUnit test for update task
	    @Test
	    @Order(5)
	    @Rollback(value = false)
	    void updateTodoTaskTest(){

	    	TodoTask todoTask = todoTaskRepository.findById(1).get();

	    	todoTask.setDescription("Updated Task");;

	    	TodoTask todoTaskUpdated =  todoTaskRepository.save(todoTask);

	        Assertions.assertThat(todoTaskUpdated.getDescription()).isEqualTo("Updated Task");

	    }
	 // JUnit test for delete task
	    @Test
	    @Order(6)
	    @Rollback(value = false)
	    void deleteTodoTaskTest(){

	    	TodoTask todotask = todoTaskRepository.findById(1).get();

	    	todoTaskRepository.delete(todotask);	        

	        TodoTask todotask1 = null;

	        Optional<TodoTask> optionaltask = todoTaskRepository.findById(1);

	        if(optionaltask.isPresent()){
	        	todotask1 = optionaltask.get();
	        }

	        Assertions.assertThat(todotask1).isNull();
	    }
	    

}
