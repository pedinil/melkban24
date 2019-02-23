package com.melk.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Know;
import com.melk.spring.model.News;
import com.melk.spring.model.Person;

@Repository
@Transactional
public class KnowDAOImpl implements KnowDAO {

	private int pageSize = 30;

	private static final Logger logger = LoggerFactory.getLogger(KnowDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Know> listKnow(int pageNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Know order by idKnow desc");

		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<Know> knowList = query.list();
		for (Know p : knowList) {
			logger.info("know List::" + p);
		}
		return knowList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Know> listKnowRandom() {
		Session session = this.sessionFactory.getCurrentSession();
		// Query query= session.createQuery("select c.IdKnow,c.SubjectKnow from
		// Know c");
		Query query = session.createQuery("select c.IdKnow,c.SubjectKnow from Know c ORDER BY RAND()");

		query.setMaxResults(5);
		List<Object[]> rows = query.list();
		List<Know> knowList = new ArrayList<Know>();
		for (Object[] item : rows) {
			Know knowItem = new Know();
			knowItem.setIdKnow((Double) item[0]);
			knowItem.setSubjectKnow((String) item[1]);
			knowList.add(knowItem);

			logger.info("know List::" + knowItem);
		}
		return knowList;
	}
	
	
	@Override
	public List<Know> listKnowSearch(String keyword) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Know where subjectKnow like :subjectKnow order by idKnow desc");
		query.setString("subjectKnow", "%"+keyword+"%");
		
		query.setMaxResults(20);

		List<Know> knowList = query.list();
		for (Know p : knowList) {
			logger.info("listKnowSearch::" + p);
		}
		return knowList;
	}
	
	

	@Override
	public Know getKnowByID(double idKnown) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Know know = null;
			Query query = session.createQuery("from Know where IdKnow=:IdKnow");
			query.setDouble("IdKnow", idKnown);
			Object obj = query.uniqueResult();

			if (obj != null) {
				know = (Know) obj;
				
				know.setCountView(know.getCountView()+1);
				session.update(know);

			}
			logger.info("news getKnowByID::" + know);

			return know;
		} catch (HibernateException e) {
			logger.error("news getKnowByID error::" + e.getMessage());
			return null;
		}
	}

	@Override
	public int getMelkCount() {
		int returnVal = 0;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select count (*) from Know");
		int countResults = ((Long) query.uniqueResult()).intValue();

		if (countResults > 0) {
			returnVal = countResults / pageSize;

			if (returnVal > 100) {
				returnVal = 100;

			}

		}

		logger.info("getMelkCount ::" + countResults);

		return returnVal;

	}

	@Override
	public boolean SaveMelk(Know knowObj) {

		try {

			Session sessionUser = sessionFactory.getCurrentSession();

			sessionUser.save(knowObj);

			logger.info("SaveMelk ::" + knowObj);

			return true;

		} catch (Exception e) {
			logger.error("SaveMelk ::" + e.getLocalizedMessage());
			return false;
		}

	}
	
	
	@Override
	public boolean UpdateMelk(Know knowObj) {

		try {

			Session sessionUser = sessionFactory.getCurrentSession();
	
	        sessionUser.update(knowObj);
			
	        logger.info("UpdateMelk ::" + knowObj);

			return true;

		} catch (Exception e) {
			logger.error("UpdateMelk ::" + e.getLocalizedMessage());
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean DeleteMelk(Know knowObj) {
		try {

			Session sessionUser = sessionFactory.getCurrentSession();
			
			
			if( knowObj != null ){
				sessionUser.delete(knowObj);
			}

	        logger.info("DeleteMelk ::" + knowObj);

			return true;

		} catch (Exception e) {
			logger.error("DeleteMelk ::" + e.getLocalizedMessage());
			return false;
		}
	}

	

}
