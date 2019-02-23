package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.CabinetDAO;
import com.melk.spring.model.Cabinet;

public class CabinetServiceImpl implements CabinetService {

	private CabinetDAO cabinetDAO;
	
	public void setCabinetDAO(CabinetDAO cabinetDAO) {
		this.cabinetDAO = cabinetDAO;
	}
	
	@Override
	@Cacheable("listCabinet")
	public List<Cabinet> listCabinet() {
		return this.cabinetDAO.listCabinet();
	}

	
	

}
