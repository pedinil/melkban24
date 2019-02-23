package com.melk.spring.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import com.melk.spring.model.City;
import com.melk.spring.model.Dynamic;
import com.melk.spring.model.Galary;




@Repository
@Transactional
public class GalaryDAOImpl implements GalaryDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(GalaryDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Galary> listGalary(int kindGallery) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query	= session.createQuery("from Galary where kindGallery=:kindGallery ");
		query.setDouble("kindGallery", kindGallery);
		List<Galary> galaryList=query.list();
		

		for(Galary p : galaryList){
			logger.info("listGalary List::"+p);
		}
		return galaryList;

		
	}

}
