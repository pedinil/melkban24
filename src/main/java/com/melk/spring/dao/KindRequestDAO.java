package com.melk.spring.dao;

import java.util.List;


import com.melk.spring.model.KindRequest;


public interface KindRequestDAO {

	public List<KindRequest> listKindRequest();
	
	public KindRequest getKindRequestId(String KindRequestName);
	
}
