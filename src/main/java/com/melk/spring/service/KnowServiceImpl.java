package com.melk.spring.service;

import java.util.List;

import com.melk.spring.dao.KnowDAO;
import com.melk.spring.model.Know;

public class KnowServiceImpl implements KnowService {

private KnowDAO knowDAO;
	
	public void setKnowDAO(KnowDAO knowDAO) {
		this.knowDAO = knowDAO;
	}
	
	@Override
	public List<Know> listKnow(int pageNo) {
		return this.knowDAO.listKnow(pageNo);
	}

	@Override
	public List<Know> listKnowRandom() {
		return this.knowDAO.listKnowRandom();
	}

	@Override
	public Know getKnowByID(double idKnown) {
		return this.knowDAO.getKnowByID(idKnown);
	}

	@Override
	public int getMelkCount() {
		return this.knowDAO.getMelkCount();
	}

	@Override
	public boolean SaveMelk(Know knowObj) {
		return this.knowDAO.SaveMelk(knowObj);
	}
	
	
	@Override
	public boolean UpdateMelk(Know knowObj) {
		return this.knowDAO.UpdateMelk(knowObj);
	}

	@Override
	public boolean DeleteMelk(Know knowObj) {
		return this.knowDAO.DeleteMelk(knowObj);
	}

	@Override
	public List<Know> listKnowSearch(String keyword) {
		return this.knowDAO.listKnowSearch(keyword);
	}
	
	
}
