package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.KindCaseDAO;
import com.melk.spring.model.KindCase;

public class KindCaseServiceImpl implements KindCaseService{

	private KindCaseDAO kindCaseDAO;

	
	public void setKindCaseDAO(KindCaseDAO kindCaseDAO) {
		this.kindCaseDAO = kindCaseDAO;
	}
	
	
	@Override
	@Cacheable("KindCase")
	public List<KindCase> listKindCase() {
			
			return this.kindCaseDAO.listKindCase();
	}


	@Override
	@Cacheable("getKindCaseId")
	public KindCase getKindCaseId(String CaseKindName) {
		return this.kindCaseDAO.getKindCaseId(CaseKindName);
	}

	
	
	
}
