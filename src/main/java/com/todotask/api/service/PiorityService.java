package com.todotask.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.todotask.api.config.exception.ResourceAlreadyExistsException;
import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.Piority;
import com.todotask.api.model.TotoTask;
import com.todotask.api.repository.PiorityRepository;

@Service
public class PiorityService {
	@Autowired
	private PiorityRepository piorityRepository;
	public Piority getPiorityByName(String name) {
		return  piorityRepository.findByName(name);
	}
	public void save(Piority piority) throws Exception {
		Piority check = piorityRepository.findByName(piority.getName());
		if (check == null) {			
			piorityRepository.save(piority);
		} else {
			throw new ResourceAlreadyExistsException("This piority already existed");
		}

	}
}
