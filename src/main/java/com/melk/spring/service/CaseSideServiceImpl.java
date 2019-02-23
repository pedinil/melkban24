package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.CaseSideDAO;
import com.melk.spring.model.CaseSide;

public class CaseSideServiceImpl implements CaseSideService {

	private CaseSideDAO caseSideDAO;
	
	public void setCaseSideDAO(CaseSideDAO caseSideDAO) {
		this.caseSideDAO = caseSideDAO;
	}
	
	@Override
	@Cacheable("listCaseSide")
	public List<CaseSide> listCaseSide() {
		return this.caseSideDAO.listCaseSide();
	}

	
	

}
