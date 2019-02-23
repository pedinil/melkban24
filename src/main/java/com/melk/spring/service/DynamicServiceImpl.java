package com.melk.spring.service;



import com.melk.spring.dao.DynamicDAO;
import com.melk.spring.model.Dynamic;


public class DynamicServiceImpl implements DynamicService {

	private DynamicDAO dynamicDAO;
	
	public void setDynamicDAO(DynamicDAO dynamicDAO) {
		this.dynamicDAO = dynamicDAO;
	}

	@Override
	public Dynamic listDynamic(double Id) {
		return this.dynamicDAO.listDynamic(Id);
	}
	

	

}
