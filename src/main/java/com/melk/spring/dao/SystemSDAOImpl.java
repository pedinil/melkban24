package com.melk.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.melk.spring.model.SystemS;
import com.melk.spring.model.Users;

@Transactional
@Repository
public class SystemSDAOImpl  implements SystemSDAO{
	
	private static final Logger logger=LoggerFactory.getLogger(SystemSDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemS> listSystemS() {
		Session session=this.sessionFactory.getCurrentSession();
		
		List<SystemS> listSystemS=session.createQuery("from SystemS").list();
		for(SystemS p : listSystemS){
			logger.info("SystemS List::"+p);
		}
		
		return listSystemS;
	}
	
	

}
