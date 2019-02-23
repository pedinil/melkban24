package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.State;



public interface StateDAO {

	public List<State> listState();
	
	public State getStateId(String StateName);
	
}
