package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.City;
import com.melk.spring.model.GuideBuy;

@Repository
@Transactional
public class GuideDAOImpl implements GuideDAO {

	private static final Logger logger = LoggerFactory.getLogger(GuideDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public boolean SaveGuide(GuideBuy guideBuyObj) {

	
		try {

			if (guideBuyObj == null)
				return false;

			
			
			
			Session sessionUser = sessionFactory.getCurrentSession();
			sessionUser.saveOrUpdate(guideBuyObj);

			logger.info("SaveGuide ::" + guideBuyObj.getCity().getIdCity() + ","
					+ guideBuyObj.getKindRequest().getIdKindRequest());

			
			return true;

		} catch (Exception e) {
			logger.error("SaveGuide ::" + e.getLocalizedMessage());
			return false;
		}

	}

	@Override
	public GuideBuy getGuideSearch(double idCity, double idKindRequest) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from GuideBuy where idCity=:idCity and idKindRequest=:idKindRequest");
		query.setDouble("idCity", idCity);
		query.setDouble("idKindRequest", idKindRequest);
		GuideBuy guideBuy =(GuideBuy)query.uniqueResult();
		
			logger.info("getGuideSearch ::"+guideBuy);
		
		return guideBuy;
	}

}
