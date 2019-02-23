package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.CaseDAO;
import com.melk.spring.model.Case;
import com.melk.spring.model.CaseAdSearch;
import com.melk.spring.model.CaseSearch;
import com.melk.spring.model.admin.CaseAdmin;

public class CaseServiceImpl implements CaseService {

	private CaseDAO caseDAO;
	
	public void setCaseDAO(CaseDAO caseDAO) {
		this.caseDAO = caseDAO;
	}
	
	@Override
	public List<Case> listCase() {
		return this.caseDAO.listCase();
	}

	@Override
	public Case getCaseDetail(double caseId) {
		return this.caseDAO.getCaseDetail(caseId);
	}

	@Override
	public List<CaseSearch> getCaseSearch(Case caseObj,CaseAdSearch caseAd,int PageNo) {
		return this.caseDAO.getCaseSearch(caseObj,caseAd,PageNo);
	}

	@Override
	//@Cacheable(value="getCaseSearchCount")
	public int getCaseSearchCount(Case caseObj,CaseAdSearch caseAd) {
		return this.caseDAO.getCaseSearchCount(caseObj,caseAd);
	}

	@Override
	public List<CaseSearch> listSaleCase() {
		return this.caseDAO.listSaleCase();
	}

	@Override
	public List<Case> listSimilarCase(Case caseObj) {
		return this.caseDAO.listSimilarCase(caseObj);
	}

	@Override
	public boolean SaveCase(Case caseObj) {
		return this.caseDAO.SaveCase(caseObj);
	}

	@Override
	public double getCaseMax() {
		return this.caseDAO.getCaseMax();
	}

	@Override
	public List<CaseAdmin> LastlistCase(int count) {
		return this.caseDAO.LastlistCase(count);
		
	}

	


}
