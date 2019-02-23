package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.KindRequestDAO;
import com.melk.spring.model.KindRequest;

public class KindRequestServiceImpl implements KindRequestService{

	private KindRequestDAO kindRequestDAO;

	
	public void setKindRequestDAO(KindRequestDAO kindRequestDAO) {
		this.kindRequestDAO = kindRequestDAO;
	}
	
	
	@Override
	@Cacheable("KindRequest")
	public List<KindRequest> listKindRequest() {
			
			return this.kindRequestDAO.listKindRequest();
	}


	@Override
	@Cacheable("getKindRequestId")
	public KindRequest getKindRequestId(String KindRequestName) {
		
		return this.kindRequestDAO.getKindRequestId(KindRequestName);
	}

}
