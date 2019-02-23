package com.melk.spring.service;

import java.util.List;

import com.melk.spring.dao.StateDAO;
import com.melk.spring.model.State;
import org.springframework.cache.annotation.Cacheable;

public class StateServiceImpl implements StateService  {

	

	private StateDAO stateDAO;
	
	public void setStateDAO(StateDAO stateDAO) {
		this.stateDAO = stateDAO;
	}
	
	
	@Override
	@Cacheable("states")
	public List<State> listState() {
		return this.stateDAO.listState();
	}


	@Override
	@Cacheable("getStateId")
	public State getStateId(String StateName) {
		
		return this.stateDAO.getStateId(StateName);
	}

}
