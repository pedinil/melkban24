package com.melk.spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="TblState")
public class State {
	


	@Id
	@Column(name="IdState")
	private Double IdState;
	
	@Column(name="NameState")
	private String NameState;
	
	
	public Double getIdState() {
		return IdState;
	}

	public void setIdState(Double idState) {
		IdState = idState;
	}

	public String getNameState() {
		return NameState;
	}

	public void setNameState(String nameState) {
		NameState = nameState;
	}

	@Override
	public String toString(){
		return "id="+IdState+", name="+NameState;
	}

	
	
	

}
