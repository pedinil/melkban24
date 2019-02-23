package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblRoof")
public class Roof {
	
	@Id
	@Column(name="fID")
	private double fID;
	
	@Column(name="NameRoof")
	private String NameRoof;

	public double getfID() {
		return fID;
	}

	public void setfID(double fID) {
		this.fID = fID;
	}

	public String getNameRoof() {
		return NameRoof;
	}

	public void setNameRoof(String nameRoof) {
		NameRoof = nameRoof;
	}

	@Override
	public String toString(){
		return "id="+fID+", name="+NameRoof;
	}

	
}
