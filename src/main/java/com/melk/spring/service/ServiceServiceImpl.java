package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.ServiceDAO;
import com.melk.spring.model.Service;

public class ServiceServiceImpl implements ServiceService {

	private ServiceDAO serviceDAO;
	
	public void setServiceDAO(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}
	
	@Override
	@Cacheable("listService")
	public List<Service> listService() {
		return this.serviceDAO.listService();
	}

	
	

}
