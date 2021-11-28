package com.todotask.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.todotask.api.config.util.TodoTaskUtil;
import com.todotask.api.dto.TodoTaskDto;
import com.todotask.api.model.Piority;
import com.todotask.api.model.TodoTask;
import com.todotask.api.repository.PiorityRepository;
import com.todotask.api.repository.TodoTaskRepository;
import com.todotask.api.response.ResponseDTO;
import com.todotask.api.service.TodoTaskService;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
@Service
public class TodoTaskServiceImpl implements  TodoTaskService {
	  
	private TodoTaskRepository todoTaskRepository;
	 
	private PiorityRepository piorityRepository;
	
	
	@Autowired
	public TodoTaskServiceImpl(TodoTaskRepository todoTaskRepository,PiorityRepository piorityRepository) {
		this.todoTaskRepository = todoTaskRepository;
		this.piorityRepository = piorityRepository;
	}
	@Override
	public ResponseDTO getAll(Optional<Integer> page,Integer size,Optional<Boolean> isDone ) {	
		
		Page<TodoTask> tasks;
		if(isDone.isEmpty()) {
			tasks= todoTaskRepository.findAll(PageRequest.of(page.orElse(0),size,Sort.by(Sort.Direction.DESC, "piority")));
		}else {
			tasks= todoTaskRepository.findByIsDone(isDone,PageRequest.of(page.orElse(0),size,Sort.by(Sort.Direction.DESC, "piority")));
		}
		return ConvertDataTodoTaskResponseDTO(tasks);
		
	}
	private ResponseDTO ConvertDataTodoTaskResponseDTO(Page<TodoTask> data)	{
		ResponseDTO responseDto= new ResponseDTO();
		List<TodoTaskDto> taskDtoList= new ArrayList<TodoTaskDto>();
		data.getContent().forEach(task -> {
			TodoTaskDto todoTaskDto = new TodoTaskDto();
			todoTaskDto.setId(task.getId());
			todoTaskDto.setDescription(task.getDescription());
			todoTaskDto.setPiorityName(task.getPiority().getName());
			todoTaskDto.setIsDone(task.getIsDone());
			todoTaskDto.setCreatedBy(task.getCreatedBy());
			taskDtoList.add(todoTaskDto);
        });
		responseDto.setPayload(taskDtoList);
		responseDto.setPageSize(data.getSize());
		responseDto.setPageNumber(data.getNumber());
		responseDto.setTotalElements(data.getNumberOfElements());
		
		return responseDto;		
	}
	@Override
	public TodoTask findByDescription(String description) {
		var data =todoTaskRepository.findByDescription(description);
		if(data.isEmpty()) {
			return null;
		}
		return  todoTaskRepository.findByDescription(description).get(0);
	}
	@Override
	public ResponseDTO findById(int id) {
		var data =todoTaskRepository.findById(id);
		if(data.isEmpty()) {
			ResponseDTO responseDTO = TodoTaskUtil.createResponseFalied("Task Does not found.");
			return responseDTO;
		}
		TodoTaskDto todoTaskDto=new TodoTaskDto();
		todoTaskDto.setId(data.get().getId());
		todoTaskDto.setIsDone(data.get().getIsDone());
		todoTaskDto.setDescription(data.get().getDescription());
		todoTaskDto.setPiorityName(data.get().getPiority().getName());
		todoTaskDto.setCreatedBy(data.get().getCreatedBy());
		ResponseDTO responseDTO = TodoTaskUtil.createResponseSuccess();
		var list = new ArrayList<TodoTaskDto>();
		list.add(todoTaskDto);
		responseDTO.setPayload(list);
		return responseDTO;
	}

	@Override
	public ResponseDTO save(TodoTaskDto taskDto) {
		
		var TotoTaskEntiry = new TodoTask();
		BeanUtils.copyProperties(taskDto, TotoTaskEntiry);
		Piority piority=piorityRepository.findByName(taskDto.getPiorityName());
		if(piority==null) {
			return TodoTaskUtil.createResponseFalied("Invalid Piority Name.");
		}
		TotoTaskEntiry.setPiority(piority);
		TotoTaskEntiry=todoTaskRepository.saveAndFlush(TotoTaskEntiry);
		ResponseDTO responseDTO = TodoTaskUtil.createResponseSuccess();
		taskDto.setId(TotoTaskEntiry.getId());
		var list = new ArrayList<TodoTaskDto>();		
		list.add(taskDto);
		responseDTO.setPayload(list);
		return responseDTO;
	}
	
	@Override
	public ResponseDTO update(TodoTaskDto taskDto) {
		Piority piority=piorityRepository.findByName(taskDto.getPiorityName());
		if(piority==null) {
			return TodoTaskUtil.createResponseFalied("Invalid Piority Name.");
		}
		Optional<TodoTask> check = todoTaskRepository.findById(taskDto.getId());
		if (check.isEmpty()) {
			return TodoTaskUtil.createResponseFalied("Task Not found.");	
		} else {
			check.get().setDescription(taskDto.getDescription());
			check.get().setIsDone(taskDto.getIsDone());
			check.get().setPiority(piority);
			todoTaskRepository.saveAndFlush(check.get());
		}
		ResponseDTO responseDTO = TodoTaskUtil.createResponseSuccess();
		var list = new ArrayList<TodoTaskDto>();		
		list.add(taskDto);
		responseDTO.setPayload(list);
		return responseDTO;
	}
	
	@Override
	public ResponseDTO delete(TodoTaskDto taskDto) {		
		Optional<TodoTask> check = todoTaskRepository.findById(taskDto.getId());
		if(check.isEmpty()) {
			return TodoTaskUtil.createResponseFalied("Invalid Task .Task does  not found.");
		} else {			
			todoTaskRepository.delete(check.get());
		}
		ResponseDTO responseDTO = TodoTaskUtil.createResponseSuccess();
		return responseDTO;
	}
}
