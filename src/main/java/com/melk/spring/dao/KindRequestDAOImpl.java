package com.melk.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.melk.spring.model.KindRequest;


@Repository
@Transactional
public class KindRequestDAOImpl implements KindRequestDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(KindRequestDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<KindRequest> listKindRequest() {
		Session session = this.sessionFactory.getCurrentSession();
		 Query query= session.createQuery("from KindRequest");
		 List<KindRequest> kindRequestList=query.list();
		for(KindRequest p : kindRequestList){
			logger.info("kindRequest List::"+p);
		}
		return kindRequestList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public KindRequest getKindRequestId(String NameKindRequest) {
		Session session = this.sessionFactory.getCurrentSession();
		 Query query= session.createQuery("from KindRequest where nameKindRequest like :NameKindRequest");
		 query.setString("NameKindRequest", NameKindRequest + "%");
		 KindRequest kindRequest=(KindRequest)query.uniqueResult();
		 
		 logger.info("getKindRequestId :"+kindRequest);
		 
		 return kindRequest;
	}

	
	
}
