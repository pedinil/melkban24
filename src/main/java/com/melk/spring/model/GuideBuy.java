package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TblGuideBuy")
public class GuideBuy {
	
	
	@Id
	@Column(name="fId")
	private int fId;
	
	
	@ManyToOne
    @JoinColumn(name = "IdKindRequest")
	private KindRequest kindRequest;
	
	
	@ManyToOne
    @JoinColumn(name = "IdCity")
 	private City city;
	
	
	@Column(name="Description")
	private String Description;
	

	public int getfId() {
		return fId;
	}


	public void setfId(int fId) {
		this.fId = fId;
	}


	public KindRequest getKindRequest() {
		return kindRequest;
	}


	public void setKindRequest(KindRequest kindRequest) {
		this.kindRequest = kindRequest;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}



	@Override
	public String toString(){
		return "IdKindRequest="+kindRequest.getIdKindRequest()+", IdCity="+city.getIdCity();
	}

}
