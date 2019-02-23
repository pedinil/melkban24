package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.WindowsDAO;
import com.melk.spring.model.Windows;

public class WindowsServiceImpl implements WindowsService {

	private WindowsDAO windowsDAO;
	
	public void setWindowsDAO(WindowsDAO windowsDAO) {
		this.windowsDAO = windowsDAO;
	}
	
	@Override
	@Cacheable("listWindows")
	public List<Windows> listWindows() {
		return this.windowsDAO.listWindows();
	}

	
	

}
