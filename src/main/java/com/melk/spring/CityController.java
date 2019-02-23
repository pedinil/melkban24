package com.melk.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.melk.spring.model.City;
import com.melk.spring.service.CityService;

@Controller
@EnableCaching
public class CityController {

    private CityService cityService;

    @Autowired(required = true)
    @Qualifier(value = "CityService")
    public void setPersonService(CityService ps) {
	this.cityService = ps;
    }

    @RequestMapping(value = "/city/json", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getListCity() {

	List<City> f = this.cityService.listCity();

	return new ResponseEntity<List<City>>(f, HttpStatus.OK);
    }

    @RequestMapping(value = "/city/json/{stateID}", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getListCitybyState(@PathVariable double stateID) {

	List<City> f = this.cityService.listCityByState(stateID);

	return new ResponseEntity<List<City>>(f, HttpStatus.OK);
    }

}
