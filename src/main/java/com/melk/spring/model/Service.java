package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblService")
public class Service {

	@Id
	@Column(name="fID")
	private double fID;
	
	
	@Column(name="ServiceName")
	private String ServiceName;
	
	
	public double getfID() {
		return fID;
	}


	public void setfID(double fID) {
		this.fID = fID;
	}


	public String getServiceName() {
		return ServiceName;
	}


	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	@Override
	public String toString(){
		return "id="+fID+", name="+ServiceName;
	}

}
