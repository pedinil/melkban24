package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Kitchen;


@Repository
@Transactional
public class KitchenDAOImpl implements KitchenDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(KitchenDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kitchen> listKitchen() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Kitchen> kitchenList= session.createQuery("from Kitchen order by fId desc").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Kitchen p : kitchenList){
			logger.info("Kitchen List::"+p);
		}
		return kitchenList;
	}

	

}
