package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.Case;
import com.melk.spring.model.CaseAdSearch;
import com.melk.spring.model.CaseSearch;
import com.melk.spring.model.admin.CaseAdmin;



public interface CaseDAO {
	
	public List<Case> listCase();
	
	public Case getCaseDetail(double caseId);
	
	public List<CaseSearch> getCaseSearch(Case caseObj,CaseAdSearch caseAd,int pageNumber);
	
	public int getCaseSearchCount(Case caseObj,CaseAdSearch caseAd); 
	
	
	//فروش ویژه
	public List<CaseSearch> listSaleCase();

	//ملک مشابه
	public List<Case> listSimilarCase(Case caseObj);
	
	
	//save to DB
	public boolean SaveCase(Case caseObj);
	
	
	//Max value
	public double getCaseMax();
		
	
	//Last case added by customer 
	public List<CaseAdmin> LastlistCase(int count);
	
	
	
	
	

}
