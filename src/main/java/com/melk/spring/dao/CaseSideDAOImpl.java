package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.CaseSide;


@Repository
@Transactional
public class CaseSideDAOImpl implements CaseSideDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(CaseSideDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CaseSide> listCaseSide() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<CaseSide> caseSideList= session.createQuery("from CaseSide").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(CaseSide p : caseSideList){
			logger.info("CaseSide List::"+p);
		}
		return caseSideList;
	}



}
