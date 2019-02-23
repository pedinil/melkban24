package com.melk.spring.service;

import java.util.List;


import com.melk.spring.model.KindRequest;

public interface KindRequestService {
	
	public List<KindRequest> listKindRequest();
	
	public KindRequest getKindRequestId(String KindRequestName);

}
