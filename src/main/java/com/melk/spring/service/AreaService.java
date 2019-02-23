package com.melk.spring.service;

import java.util.List;

import com.melk.spring.model.Area;
import com.melk.spring.model.City;

public interface AreaService {
	
	public List<Area> listArea();
	
	public List<Area> listAreaByCity(double CityID);
	
	public Area getAreaId(String AreaName,double CityID);

}
