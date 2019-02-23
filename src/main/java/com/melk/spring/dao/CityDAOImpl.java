package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.City;


@Repository
@Transactional
public class CityDAOImpl implements CityDAO {

	private static final Logger logger = LoggerFactory.getLogger(CityDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCity() {
		Session session = this.sessionFactory.getCurrentSession();
		List<City> cityList = session.createQuery("from City").list();
		for(City p : cityList){
			logger.info("City List::"+p);
		}
		return cityList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCityByState(double IdState) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from City where IdState=:IdState");
		query.setDouble("IdState", IdState);
		List<City> cityList =query.list();
		for(City p : cityList){
			logger.info("CityByState List::"+p);
		}
		return cityList;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public City getCityId(String NameCity,double IdState) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from City where NameCity=:NameCity and IdState=:IdState");
		query.setString("NameCity", NameCity );
		query.setDouble("IdState", IdState);
		
		City city=(City)query.uniqueResult();
		
		logger.info("getCityId :"+ city);
		 
		 return city;
		
	}

}
