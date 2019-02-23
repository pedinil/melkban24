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

import com.melk.spring.model.Range;
import com.melk.spring.service.RangeService;
import com.melk.spring.service.RangeService;


@Controller
@EnableCaching
public class RangeController {

	
private RangeService rangeService;
	
	@Autowired(required=true)
	@Qualifier(value="RangeService")
	public void setPersonService(RangeService ps){
		this.rangeService = ps;
	}
	
	@RequestMapping(value = "/range/json", method = RequestMethod.GET)
	public  ResponseEntity<List<Range>> getListRange(Model model) {
	
		List<Range> f=this.rangeService.listRange();
		
		  return new ResponseEntity<List<Range>>(f, HttpStatus.OK);
	}
	
	
 
	@RequestMapping(value = "/range/json/{IdArea}", method = RequestMethod.GET)
	public  ResponseEntity<List<Range>> getListRangeByCity(@PathVariable double IdArea) {
	
		List<Range> f=this.rangeService.listRangeByArea(IdArea);
		
		  return new ResponseEntity<List<Range>>(f, HttpStatus.OK);
	}
	
}
