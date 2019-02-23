package com.melk.spring.service;



import com.melk.spring.model.GuideBuy;



public interface GuideService {
	

	//search in DB 
	public GuideBuy getGuideSearch(double idCity,double idKindRequest);
	
	//save to DB
	public boolean SaveGuide(GuideBuy guideBuyObj);

}
