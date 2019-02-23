package com.melk.spring.service;

import java.util.List;


import com.melk.spring.model.Case;
import com.melk.spring.model.CaseAdSearch;
import com.melk.spring.model.CaseSearch;
import com.melk.spring.model.admin.CaseAdmin;

public interface CaseService {
	
	public List<Case> listCase();
	
	public Case getCaseDetail(double caseId);
	
	public List<CaseSearch> getCaseSearch(Case caseObj,CaseAdSearch caseAd,int PageNo);
	
	
	public int getCaseSearchCount(Case caseObj,CaseAdSearch caseAd);
	
	//فروش ویژه
	public List<CaseSearch> listSaleCase();
	
	//ملک مشابه
	public List<Case> listSimilarCase(Case caseObj);
	
	
	public boolean SaveCase(Case caseObj);
	

	public double getCaseMax();
	
	//Last case added by customer 
	public List<CaseAdmin> LastlistCase(int count);
	

}
