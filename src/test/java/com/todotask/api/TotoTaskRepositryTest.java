package com.todotask.api;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.todotask.api.model.Piority;
import com.todotask.api.model.TotoTask;
import com.todotask.api.repository.PiorityRepository;
import com.todotask.api.repository.TodoTaskRepository;


@SpringBootTest
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

	        Assertions.assertThat(todoTask.getId()).isGreaterThan(0);
	    }
	    @Test
	    @Order(3)
	    public void getTodoTaskTest(){

	    	TotoTask totoTask = totoTaskRepository.findById(1).get();

	        Assertions.assertThat(totoTask.getId()).isEqualTo(1);

	    }
	    

}
