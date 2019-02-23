package com.melk.spring.service;

import java.util.List;

import com.melk.spring.model.City;



public interface CityService {
	
	public List<City> listCity();
	
	public List<City> listCityByState(double stateId);
	
	public City getCityId(String CityName,double stateId);

}
