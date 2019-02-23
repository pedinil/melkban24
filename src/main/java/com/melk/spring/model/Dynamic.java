package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblDynamic")
public class Dynamic {

	@Id
	@Column(name="Id")
	private double Id;
	
	@Column(name="Body")
	private String Body;
	
	
	public double getId() {
		return Id;
	}

	public void setId(double id) {
		Id = id;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	
	
}
