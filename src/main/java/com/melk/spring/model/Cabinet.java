package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblCabinet")
public class Cabinet {
	
	
	@Id
	@Column(name="fID")
	private double fID;
	
	@Column(name="CabinetName")
	private String CabinetName;
	
	public double getfID() {
		return fID;
	}

	public void setfID(double fID) {
		this.fID = fID;
	}

	public String getCabinetName() {
		return CabinetName;
	}

	public void setCabinetName(String cabinetName) {
		CabinetName = cabinetName;
	}

	
	@Override
	public String toString(){
		return "id="+fID+", name="+CabinetName;
	}

	

}
