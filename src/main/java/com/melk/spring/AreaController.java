package com.melk.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.melk.spring.model.Area;
import com.melk.spring.service.AreaService;

@Controller
@EnableCaching
public class AreaController {

    private AreaService areaService;

    @Autowired(required = true)
    @Qualifier(value = "AreaService")
    public void setPersonService(AreaService ps) {
	this.areaService = ps;
    }

    @RequestMapping(value = "/area/json", method = RequestMethod.GET)
    public ResponseEntity<List<Area>> getListArea(Model model) {

	List<Area> f = this.areaService.listArea();

	return new ResponseEntity<List<Area>>(f, HttpStatus.OK);
    }

    @RequestMapping(value = "/area/json/{CityID}", method = RequestMethod.GET)
    public ResponseEntity<List<Area>> getListAreaByCity(@PathVariable double CityID) {

	List<Area> f = this.areaService.listAreaByCity(CityID);

	return new ResponseEntity<List<Area>>(f, HttpStatus.OK);
    }

}
