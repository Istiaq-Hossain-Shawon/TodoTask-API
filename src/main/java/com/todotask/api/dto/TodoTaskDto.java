package com.todotask.api.dto;


public class TodoTaskDto {
	
	private int id;

	private String description;
	
	private Boolean isDone;
	
	private String piorityName; 
	
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

	public TodoTaskDto(int id, String description,Boolean isDone,String piorityName,String createdBy) {
		super();
		this.id = id;
		this.setDescription(description);
		this.setIsDone(isDone);
		this.setPiorityName(piorityName);
		this.setCreatedBy(createdBy);
		
		
	}
	public TodoTaskDto() {
		
		
		
	}
	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}



	public String getPiorityName() {
		return piorityName;
	}

	public void setPiorityName(String piorityName) {
		this.piorityName = piorityName;
	}

	
	
	
}
