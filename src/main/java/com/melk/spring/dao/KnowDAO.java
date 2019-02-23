package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.Know;


public interface KnowDAO {
	
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
	
	//search by keyword
	public List<Know> listKnowSearch(String keyword);
	
}
