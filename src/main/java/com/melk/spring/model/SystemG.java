package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblSystemG")
public class SystemG {
	
	@Id
	@Column(name="fID")
	private double fID;
	
	@Column(name="SystemGName")
	private String SystemGName;
	
	public double getfID() {
		return fID;
	}

	public void setfID(double fID) {
		this.fID = fID;
	}

	public String getSystemGName() {
		return SystemGName;
	}

	public void setSystemGName(String systemGName) {
		SystemGName = systemGName;
	}


	@Override
	public String toString(){
		return "id="+fID+", name="+SystemGName;
	}

}
