package com.melk.spring.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.melk.spring.model.Dynamic;



@Repository
@Transactional
public class DynamicDAOImpl implements DynamicDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(DynamicDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public Dynamic listDynamic(double Id) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query	= session.createQuery("from Dynamic where Id=:Id ");
		query.setDouble("Id", Id);
		Dynamic dynamic=(Dynamic)query.uniqueResult();
		
		logger.info("listDynamic :"+dynamic);
		
		return dynamic;
		
		
	}

}
