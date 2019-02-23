package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.KindRequest;
import com.melk.spring.model.Range;



@Repository
@Transactional
public class RangeDAOImpl implements RangeDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(RangeDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Range> listRange() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Range> rangeList= session.createQuery("from Range").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Range p : rangeList){
			logger.info("Range List::"+p);
		}
		return rangeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Range> listRangeByArea(double IdArea) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query	= session.createQuery("from Range where IdArea=:IdArea");
		query.setDouble("IdArea", IdArea);
		List<Range> rangeList=query.list();
		for(Range p : rangeList){
			logger.info("RangeByArea List::"+p);
		}
		return rangeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Range getRangeId(String NameRange,double IdArea) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query	= session.createQuery("from Range where NameRange like :NameRange and IdArea=:IdArea");
		query.setString("NameRange", NameRange+"%" );
		query.setDouble("IdArea", IdArea);
		
		Range range=(Range)query.uniqueResult();
		 
		 logger.info("getRangeId :"+range);
		 
		 return range;
	}

	

}
