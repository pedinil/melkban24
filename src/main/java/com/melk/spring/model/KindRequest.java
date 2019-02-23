package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblKindRequest")
public class KindRequest {
	
	@Id
	@Column(name="IdKindRequest")
	private double IdKindRequest;
	
	@Column(name="NameKindRequest")
	private String NameKindRequest;
	
	
	public double getIdKindRequest() {
		return IdKindRequest;
	}

	public void setIdKindRequest(double idKindRequest) {
		IdKindRequest = idKindRequest;
	}

	public String getNameKindRequest() {
		return NameKindRequest;
	}

	public void setNameKindRequest(String nameKindRequest) {
		NameKindRequest = nameKindRequest;
	}

	@Override
	public String toString(){
		return "id="+IdKindRequest+", name="+NameKindRequest;
	}
	

}
