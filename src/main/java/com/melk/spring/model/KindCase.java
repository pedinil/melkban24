package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblKindCase")
public class KindCase {
	
	@Id
	@Column(name="IdKindCase")
	private double IdKindCase;
	
	@Column(name="NameKindCase")
	private String NameKindCase;

	public double getIdKindCase() {
		return IdKindCase;
	}

	public void setIdKindCase(double idKindCase) {
		IdKindCase = idKindCase;
	}

	public String getNameKindCase() {
		return NameKindCase;
	}

	public void setNameKindCase(String nameKindCase) {
		NameKindCase = nameKindCase;
	}

	@Override
	public String toString(){
		return "id="+IdKindCase+", name="+NameKindCase;
	}
	
}
