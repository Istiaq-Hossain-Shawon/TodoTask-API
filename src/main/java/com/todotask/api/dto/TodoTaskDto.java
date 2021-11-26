package com.todotask.api.dto;

import com.todotask.api.model.Piority;

public class TodoTaskDto {
	
	private int id;

	private String description;
	
	private Boolean isDone;
	
	private Piority piority; 
	
	private String createdBy;
	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

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

	public TodoTaskDto(int id, String description,Boolean isDone,Piority piority) {
		super();
		this.id = id;
		this.setDescription(description);
		this.setIsDone(isDone);
		this.setPiority(piority);
		
		
	}
	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Piority getPiority() {
		return piority;
	}

	public void setPiority(Piority piority) {
		this.piority = piority;
	}
	
	
}
