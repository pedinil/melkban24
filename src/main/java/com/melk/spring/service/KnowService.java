package com.melk.spring.service;

import java.util.List;

import com.melk.spring.model.Know;


public interface KnowService {
	
	public List<Know> listKnow(int pageNo);
	
	public List<Know> listKnowRandom();
	
	public Know getKnowByID(double idKnown);
	
	public int getMelkCount();
	
	//save to DB
	public boolean SaveMelk(Know knowObj);
	
	//Update to DB
	public boolean UpdateMelk(Know knowObj);
	
	//Delete from DB
	public boolean DeleteMelk(Know knowObj);
	
	//seearch by keyword
	public List<Know> listKnowSearch(String keyword);

}
