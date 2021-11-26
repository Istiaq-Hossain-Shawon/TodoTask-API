package com.todotask.api.dto;

public class TodoTaskDto {
	
	private int id;

	private String description;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 

	public TodoTaskDto(int i, String description) {
		super();
		this.id = i;
		this.setDescription(description);
		
	}
	
	
}
