package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblCaseSide")
public class CaseSide {

	
	@Id
	@Column(name="fID")
	private double fID;
	
	@Column(name="Name")
	private String Name;
	
	public double getfID() {
		return fID;
	}

	public void setfID(double fID) {
		this.fID = fID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString(){
		return "id="+fID+", name="+Name;
	}
	

	
}
