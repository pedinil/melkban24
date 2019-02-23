package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.CityDAO;
import com.melk.spring.model.City;

public class CityServiceImpl implements CityService {

	
	private CityDAO cityDAO;
	
	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	
	@Override
	public List<City> listCity() {
		return this.cityDAO.listCity();
	}

	
	@Override
	@Cacheable("listCityByState")
	public List<City> listCityByState(double stateId) {
		return this.cityDAO.listCityByState(stateId);
	}


	@Override
	@Cacheable("getCityId")
	public City getCityId(String CityName,double stateId) {
		return this.cityDAO.getCityId(CityName, stateId);
	}

}
