package com.melk.spring.service;

import java.util.List;

import com.melk.spring.dao.GuideDAO;
import com.melk.spring.model.GuideBuy;


public  class GuideServiceImpl implements GuideService {

private GuideDAO guideDAO;
	
	public void setGuideDAO(GuideDAO guideDAO) {
		this.guideDAO = guideDAO;
	}

	

	@Override
	public boolean SaveGuide(GuideBuy guideBuyObj) {
		return this.guideDAO.SaveGuide(guideBuyObj);
	}



	@Override
	public GuideBuy getGuideSearch(double idCity, double idKindRequest) {
		return this.guideDAO.getGuideSearch(idCity, idKindRequest);

	}
	
	
}
