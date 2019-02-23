package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblArea")
public class Area {
	
	@Id
	@Column(name="IdArea")
	private double IdArea;
	
	@Column(name="NameArea")
	private String NameArea;
	
	@Column(name="IdCity")
	private double IdCity;
	
	
	public double getIdArea() {
		return IdArea;
	}

	public void setIdArea(double idArea) {
		IdArea = idArea;
	}

	public String getNameArea() {
		return NameArea;
	}

	public void setNameArea(String nameArea) {
		NameArea = nameArea;
	}

	public double getIdCity() {
		return IdCity;
	}

	public void setIdCity(double idCity) {
		IdCity = idCity;
	}


	
	@Override
	public String toString(){
		return "id="+IdArea+", name="+NameArea+", idState="+IdCity;
	}
	
	
	

}
