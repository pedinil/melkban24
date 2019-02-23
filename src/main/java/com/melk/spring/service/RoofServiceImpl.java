package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.RoofDAO;
import com.melk.spring.model.Roof;

public class RoofServiceImpl implements RoofService {

	private RoofDAO roofDAO;
	
	public void setRoofDAO(RoofDAO roofDAO) {
		this.roofDAO = roofDAO;
	}
	
	@Override
	@Cacheable("listRoof")
	public List<Roof> listRoof() {
		return this.roofDAO.listRoof();
	}

	
	

}
