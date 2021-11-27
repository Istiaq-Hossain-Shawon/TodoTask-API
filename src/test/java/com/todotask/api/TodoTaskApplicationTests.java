package com.todotask.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.todotask.api.model.Piority;
import com.todotask.api.model.TodoTask;
import com.todotask.api.repository.PiorityRepository;
import com.todotask.api.repository.TodoTaskRepository;

@SpringBootTest
class TodoTaskApplicationTests {

	@Test
	void contextLoads() {
	}
	


}
