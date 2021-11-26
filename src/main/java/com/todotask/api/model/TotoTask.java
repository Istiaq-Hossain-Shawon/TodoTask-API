package com.todotask.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="todotask_tbl")
public class TotoTask {

	@Id
	private int id;

	

	private String description;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "piorityId", nullable = false)
	private Piority piority; 
	
	private Boolean isDone;



	public TotoTask(){
		   
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Piority getPiority() {
		return piority;
	}

	public void setPiority(Piority piority) {
		this.piority = piority;
	}
	
}
