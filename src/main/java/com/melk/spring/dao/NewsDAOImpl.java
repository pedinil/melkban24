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

import com.melk.spring.model.News;

@Repository
@Transactional
public class NewsDAOImpl implements NewsDAO {

	private int pageSize = 20;

	private static final Logger logger = LoggerFactory.getLogger(NewsDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> listNewsWithMaxNo(int count) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from News order by IdNews desc");

		query.setMaxResults(count);

		List<News> newsList = query.list();

		for (News p : newsList) {
			logger.info("news listNewsWithMaxNo::" + p);
		}
		return newsList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<News> listNewsSearch(String keyword) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from News where subjectNews like :subjectNews order by IdNews desc");
		query.setString("subjectNews", "%"+keyword+"%");
		query.setMaxResults(30);

		List<News> newsList = query.list();

		for (News p : newsList) {
			logger.info("news listNewsSearch::" + p);
		}
		return newsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> listNews(int PageNo) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from News order by IdNews desc");

		query.setFirstResult((PageNo - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<News> newsList = query.list();
		for (News p : newsList) {
			logger.info("news List::" + p);
		}
		return newsList;
	}

	@Override
	public News getNewsByID(double newsID) {
		Session session = this.sessionFactory.getCurrentSession();
		News news = null;
		Query query = session.createQuery("from News where IdNews=:IdNews");
		query.setDouble("IdNews", newsID);
		Object obj = query.uniqueResult();

		if (obj != null) {
			news = (News) obj;

		}
		logger.info("news getNewsByID::" + news);

		return news;
	}

	@Override
	public int getNewsCount() {
		int returnVal = 0;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select count (*) from News");
		int countResults = ((Long) query.uniqueResult()).intValue();

		if (countResults > 0) {
			returnVal = countResults / pageSize;

			if (returnVal > 100) {
				returnVal = 100;

			}

		}

		logger.info("getNewsCount ::" + countResults);

		return returnVal;

	}

	@Override
	public double getNewsMax() {
		double returnVal = 0;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select max (IdNews) from News");
		returnVal = (Double) query.uniqueResult();

		logger.info("getNewsMax ::" + returnVal);

		return returnVal;
	}

	@Override
	public boolean SaveNews(News newsObj) {

		try {

			Session sessionUser = this.sessionFactory.getCurrentSession();

			sessionUser.save(newsObj);


			logger.info("SaveNews ::" + newsObj);

			return true;

		} catch (Exception e) {

			logger.error("SaveNews ::" + e.getLocalizedMessage());
			return false;
		}

	}
	
	
	@Override
	public boolean UpdateNews(News newsObj) {

		try {

			Session sessionUser = this.sessionFactory.getCurrentSession();

			sessionUser.update(newsObj);


			logger.info("SaveUpdate ::" + newsObj);

			return true;

		} catch (Exception e) {

			logger.error("SaveUpdate ::" + e.getLocalizedMessage());
			return false;
		}

	}

	@Override
	public boolean DeleteNews(News newsObj) {
		try {

			Session sessionUser = this.sessionFactory.getCurrentSession();

			if (newsObj != null)
			{
			 sessionUser.delete(newsObj);
			}

			logger.info("DeleteNews ::" + newsObj);

			return true;

		} catch (Exception e) {

			logger.error("DeleteNews ::" + e.getLocalizedMessage());
			return false;
		}
	}

	

}
