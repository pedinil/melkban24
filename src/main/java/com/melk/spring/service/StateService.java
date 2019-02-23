package com.melk.spring.service;

import java.util.List;

import com.melk.spring.model.State;



public interface StateService {

	public List<State> listState();
	
	public State getStateId(String StateName);
}
