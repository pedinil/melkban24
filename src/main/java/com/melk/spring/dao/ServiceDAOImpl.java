package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Service;


@Repository
@Transactional
public class ServiceDAOImpl implements ServiceDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(ServiceDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> listService() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Service> serviceList= session.createQuery("from Service").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Service p : serviceList){
			logger.info("Service List::"+p);
		}
		return serviceList;
	}

	

}
