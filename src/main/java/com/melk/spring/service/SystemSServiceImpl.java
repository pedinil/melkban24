package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.SystemSDAO;
import com.melk.spring.model.SystemS;

public class SystemSServiceImpl implements SystemSService {

	private SystemSDAO systemSDAO;

	public void setSystemSDAO(SystemSDAO systemSDAO) {
		this.systemSDAO = systemSDAO;
	}	
	@Override
	@Cacheable("listSystemS")
	public List<SystemS> listSystemS() {
		
		return this.systemSDAO.listSystemS();
	}


}
