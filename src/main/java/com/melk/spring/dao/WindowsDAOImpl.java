package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Windows;


@Repository
@Transactional
public class WindowsDAOImpl implements WindowsDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(WindowsDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Windows> listWindows() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Windows> windowsList= session.createQuery("from Windows order by fId desc").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Windows p : windowsList){
			logger.info("Windows List::"+p);
		}
		return windowsList;
	}

	

}
