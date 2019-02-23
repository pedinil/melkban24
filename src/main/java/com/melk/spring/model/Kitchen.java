package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblKitchen")
public class Kitchen {

	
	@Id
	@Column(name="fID")
	private double fID;
	
	
	@Column(name="KitchenName")
	private String KitchenName;
	
	
	public double getfID() {
		return fID;
	}


	public void setfID(double fID) {
		this.fID = fID;
	}


	public String getKitchenName() {
		return KitchenName;
	}


	public void setKitchenName(String kitchenName) {
		KitchenName = kitchenName;
	}

	@Override
	public String toString(){
		return "id="+fID+", name="+KitchenName;
	}

	
}
