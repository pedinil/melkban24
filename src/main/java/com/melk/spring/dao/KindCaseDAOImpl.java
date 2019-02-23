package com.melk.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.melk.spring.model.KindCase;
import com.melk.spring.model.KindRequest;


@Repository
@Transactional
public class KindCaseDAOImpl implements KindCaseDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(KindCaseDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<KindCase> listKindCase() {
		Session session = this.sessionFactory.getCurrentSession();
		 Query query= session.createQuery("from KindCase");
		 List<KindCase> kindCaseList=query.list();
		for(KindCase p : kindCaseList){
			logger.info("kindCase List::"+p);
		}
		return kindCaseList;
	}


	@Override
	public KindCase getKindCaseId(String CaseKindName) {
		Session session = this.sessionFactory.getCurrentSession();
		 Query query= session.createQuery("from KindCase where NameKindCase like :NameKindCase");
		 query.setString("NameKindCase", CaseKindName + "%");
		 KindCase kindCase=(KindCase)query.uniqueResult();
		 
		 logger.info("getKindCaseId :"+kindCase);
		 
		 return kindCase;
		 
	}

	
	
}
