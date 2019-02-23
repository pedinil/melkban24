package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.City;



public interface CityDAO {
	
	public List<City> listCity();
	
	public List<City> listCityByState(double stateId);
	
	public City getCityId(String CityName,double stateId);

}
