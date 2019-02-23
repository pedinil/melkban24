package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblSystemS")
public class SystemS {
	
	@Id
	@Column(name="fID")
	private double fID;
	
	@Column(name="SystemSName")
	private String SystemSName;
	
	public double getfID() {
		return fID;
	}

	public void setfID(double fID) {
		this.fID = fID;
	}

	public String getSystemSName() {
		return SystemSName;
	}

	public void setSystemSName(String systemSName) {
		SystemSName = systemSName;
	}

	@Override
	public String toString(){
		return "id="+fID+", name="+SystemSName;
	}

}
