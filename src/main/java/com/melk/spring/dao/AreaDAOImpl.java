package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Area;
import com.melk.spring.model.KindCase;


@Repository
@Transactional
public class AreaDAOImpl implements AreaDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(AreaDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> listArea() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Area> areaList= session.createQuery("from Area").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Area p : areaList){
			logger.info("Area List::"+p);
		}
		return areaList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> listAreaByCity(double IdCity) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query	= session.createQuery("from Area where IdCity=:IdCity");
		query.setDouble("IdCity", IdCity);
		List<Area> areaList=query.list();
		for(Area p : areaList){
			logger.info("AreaByCity List::"+p);
		}
		return areaList;
	}

	@Override
	public Area getAreaId(String NameArea,double IdCity) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query	= session.createQuery("from Area where NameArea=:NameArea and IdCity=:IdCity");
		query.setString("NameArea", NameArea );
		query.setDouble("IdCity", IdCity);
		Area area=(Area)query.uniqueResult();
		
		logger.info("getAreaId :"+area);
		
		return area;
		
		
	}

}
