package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Roof;


@Repository
@Transactional
public class RoofDAOImpl implements RoofDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(RoofDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roof> listRoof() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Roof> roofList= session.createQuery("from Roof order by fID desc").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Roof p : roofList){
			logger.info("Roof List::"+p);
		}
		return roofList;
	}

	

}
