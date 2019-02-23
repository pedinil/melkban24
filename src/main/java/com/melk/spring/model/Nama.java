package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblNama")
public class Nama {

	
	@Id
	@Column(name="fID")
	private double fID;
	
	@Column(name="NamaName")
	private String NamaName;
	
	public double getfID() {
		return fID;
	}

	public void setfID(double fID) {
		this.fID = fID;
	}

	public String getNamaName() {
		return NamaName;
	}

	public void setNamaName(String namaName) {
		NamaName = namaName;
	}

	@Override
	public String toString(){
		return "id="+fID+", name="+NamaName;
	}

}
