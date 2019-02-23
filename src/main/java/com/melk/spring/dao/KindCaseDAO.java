package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.KindCase;


public interface KindCaseDAO {

	public List<KindCase> listKindCase();
	
	public KindCase getKindCaseId(String CaseKindName);
	
}
