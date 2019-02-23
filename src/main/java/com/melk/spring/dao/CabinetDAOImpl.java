package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Cabinet;


@Repository
@Transactional
public class CabinetDAOImpl implements CabinetDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(CabinetDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cabinet> listCabinet() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Cabinet> cabinetList= session.createQuery("from Cabinet order by cabinetName ").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Cabinet p : cabinetList){
			logger.info("Cabinet List::"+p);
		}
		return cabinetList;
	}

	

}
