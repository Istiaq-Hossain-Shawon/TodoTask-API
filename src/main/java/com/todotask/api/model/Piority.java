package com.todotask.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "piority_tbl")
public class Piority {
	@Id
	private int piorityId;

	private String name;

	public Piority(int id, String name) {
		super();
		this.piorityId=id;
		this.setName(name);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
