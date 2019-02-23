package com.melk.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.melk.spring.model.State;
import com.melk.spring.service.StateService;
import org.springframework.cache.annotation.EnableCaching;


@Controller
@EnableCaching
public class StateController {
	
	
	private StateService stateService;
	
	
	@Autowired(required=true)
	@Qualifier(value="StateService")
	public void setUsersService(StateService ps){
		this.stateService = ps;
	}

	
	
	@RequestMapping(value = "/state/json", method = RequestMethod.GET)
	public  ResponseEntity<List<State>> getListState(Model model) {
	
		List<State> f=this.stateService.listState();
		
		  return new ResponseEntity<List<State>>(f, HttpStatus.OK);
	}
	
	
}
