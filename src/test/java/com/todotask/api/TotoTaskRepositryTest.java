package com.todotask.api;


import java.util.Arrays;
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
import com.todotask.api.model.TotoTask;
import com.todotask.api.repository.PiorityRepository;
import com.todotask.api.repository.TodoTaskRepository;
import org.junit.jupiter.api.MethodOrderer;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TotoTaskRepositryTest {
	    @Autowired
	    private TodoTaskRepository totoTaskRepository;
	    
	    @Autowired
	    private PiorityRepository piorityRepository;

	 // JUnit test for savePiority
	    @Test
	    @Order(1)
	    @Rollback(value = false)
	    public void savePiorityTest(){
	    	Piority piority =new Piority();
	    	piority.setPiorityId(1);
	    	piority.setName("low");
	    	piorityRepository.save(piority);
	        Assertions.assertThat(piority.getPiorityId()).isGreaterThan(0);
	    }
	    
	    // JUnit test for saveTodoTask
	    @Test
	    @Order(2)
	    @Rollback(value = false)
	    public void saveTodoTaskTest(){

	    	TotoTask todoTask =new TotoTask();
	    	
	    	todoTask.setDescription("Task 123");
	    	todoTask.setIsDone(false);
	    	todoTask.setPiority(piorityRepository.findByName("low"));
	    	totoTaskRepository.save(todoTask);
	    	System.out.println("INSERTED TASK:");
	    	System.out.println(todoTask);
	    	System.out.println(todoTask.getId());
	        Assertions.assertThat(todoTask.getId()).isGreaterThan(0);
	    }
	    @Test
	    @Order(3)
	    public void getTodoTaskTest(){

	    	TotoTask totoTask = totoTaskRepository.findById(1).get();

	        Assertions.assertThat(totoTask.getId()).isEqualTo(1);

	    }
	    @Test
	    @Order(4)
	    public void getListOfTaskTest(){

	        List<TotoTask> totoTasks = totoTaskRepository.findAll();
	        System.out.println("GET TASKS:");
	        for(TotoTask model : totoTasks) {
	            System.out.println(model.getId());
	            System.out.println(model.getDescription());
	        }

	        Assertions.assertThat(totoTasks.size()).isGreaterThan(0);

	    }
	    @Test
	    @Order(5)
	    @Rollback(value = false)
	    public void updateTodoTaskTest(){

	    	TotoTask totoTask = totoTaskRepository.findById(1).get();

	    	totoTask.setDescription("Updated Task");;

	    	TotoTask totoTaskUpdated =  totoTaskRepository.save(totoTask);

	        Assertions.assertThat(totoTaskUpdated.getDescription()).isEqualTo("Updated Task");

	    }
	    @Test
	    @Order(6)
	    @Rollback(value = false)
	    public void deleteEmployeeTest(){

	    	TotoTask todotask = totoTaskRepository.findById(1).get();

	    	totoTaskRepository.delete(todotask);	        

	        TotoTask todotask1 = null;

	        Optional<TotoTask> optionaltask = totoTaskRepository.findById(1);

	        if(optionaltask.isPresent()){
	        	todotask1 = optionaltask.get();
	        }

	        Assertions.assertThat(todotask1).isNull();
	    }
	    

}
