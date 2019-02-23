package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.AreaDAO;
import com.melk.spring.model.Area;

public class AreaServiceImpl implements AreaService {

	private AreaDAO areaDAO;
	
	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	
	@Override
	public List<Area> listArea() {
		return this.areaDAO.listArea();
	}

	
	@Override
	@Cacheable("listAreaByCity")
	public List<Area> listAreaByCity(double IdCity) {
		return this.areaDAO.listAreaByCity(IdCity);
	}

	@Override
	@Cacheable("getAreaId")
	public Area getAreaId(String AreaName,double CityID) {
		return this.areaDAO.getAreaId(AreaName,CityID);
	}

}
