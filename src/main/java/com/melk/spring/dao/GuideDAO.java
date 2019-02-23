package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.GuideBuy;



public interface GuideDAO {
	

	
	//search in DB 
	public GuideBuy getGuideSearch(double idCity,double idKindRequest);
	
	//save to DB
	public boolean SaveGuide(GuideBuy guideBuyObj);
	
}
