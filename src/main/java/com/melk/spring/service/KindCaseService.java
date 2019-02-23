package com.melk.spring.service;

import java.util.List;


import com.melk.spring.model.KindCase;

public interface KindCaseService {
	
	public List<KindCase> listKindCase();
	
	public KindCase getKindCaseId(String CaseKindName);
	
	

}
