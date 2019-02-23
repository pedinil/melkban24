package com.melk.spring.dao;
import com.melk.spring.model.SystemG;
import com.melk.spring.model.SystemS;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SystemGDAOImpl implements SystemGDAO{
	
	private static final Logger logger=LoggerFactory.getLogger(SystemGDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemG> listSystemG() {
		Session session=this.sessionFactory.getCurrentSession();
		List<SystemG> listSystemG=session.createQuery("from SystemG").list();
		
		for(SystemG p : listSystemG){
			logger.info("SystemG List::"+p);
		}
		
		return listSystemG;
	}

	
}
