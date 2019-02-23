package com.melk.spring.service;
import java.util.List;

import com.melk.spring.model.SystemG;
import com.melk.spring.dao.SystemGDAO;

import org.springframework.cache.annotation.Cacheable;


public class SystemGServiceImpl implements SystemGService{
	
	private SystemGDAO systemGDAO;
	
	public void setSystemGDAO(SystemGDAO systemGDAO) {
		this.systemGDAO = systemGDAO;
	}

	@Override
	@Cacheable("listSystemG")
	public List<SystemG> listSystemG() {
		
		return this.systemGDAO.listSystemG();
	}
	
	

}
