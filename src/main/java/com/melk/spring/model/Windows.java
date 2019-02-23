package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblWindows")
public class Windows {

	
	@Id
	@Column(name="fID")
	private double fID;
	
	
	@Column(name="WindowsName")
	private String WindowsName;
	
	
	public double getfID() {
		return fID;
	}


	public void setfID(double fID) {
		this.fID = fID;
	}


	public String getWindowsName() {
		return WindowsName;
	}


	public void setWindowsName(String windowsName) {
		WindowsName = windowsName;
	}


	@Override
	public String toString(){
		return "id="+fID+", name="+WindowsName;
	}
}
