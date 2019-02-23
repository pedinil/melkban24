package com.melk.spring.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;
import com.melk.spring.model.Case;
import com.melk.spring.model.CaseAdSearch;
import com.melk.spring.model.CaseSearch;
import com.melk.spring.model.Users;
import com.melk.spring.model.admin.CaseAdmin;

@Repository
@Transactional
public class CaseDAOImpl implements CaseDAO  {

	private static final Logger logger = LoggerFactory.getLogger(CaseDAOImpl.class);

	private int pageSize = 10;
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Case> listCase() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Case");
		
		

		query.setMaxResults(10);
		List<Case> caseList = query.list();
		for (Case p : caseList) {
			logger.info("Case List::" + p);
		}
		return caseList;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<CaseSearch> getCaseSearch(Case caseObj, CaseAdSearch caseAd, int pageNumber) {

		Session session = this.sessionFactory.getCurrentSession();
		/*
		 * Query countQ=
		 * session.createQuery("Select count (IdCase) from CaseSearch "); Long
		 * countResults = (Long) countQ.uniqueResult(); int lastPageNumber =
		 * (int) ((countResults / pageSize) + 1);
		 */

		StringBuilder strQuery = new StringBuilder();

		strQuery.append("from CaseSearch Where ");

		SearchQueryMake(caseObj, caseAd, strQuery);

		strQuery.append("order by intDayOn desc ");

		Query query = session.createQuery(strQuery.toString());

		SearchQueryParamterMake(caseObj, caseAd, query);

		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<CaseSearch> listcaseSearch = query.list();
		for (CaseSearch p : listcaseSearch) {
			logger.info("CaseSearch ::" + p);
		}

		return listcaseSearch;

	}


	@SuppressWarnings("unchecked")
	@Override
	public int getCaseSearchCount(Case caseObj, CaseAdSearch caseAd) {
		int returnVal = 0;
		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder strQuery = new StringBuilder();

		strQuery.append("Select count (*) from CaseSearch Where ");

		SearchQueryMake(caseObj, caseAd, strQuery);

		Query query = session.createQuery(strQuery.toString());

		SearchQueryParamterMake(caseObj, caseAd, query);

		int countResults = ((Long) query.uniqueResult()).intValue();

		if (countResults > 0) {
			returnVal = countResults / pageSize;

			if (returnVal > 100) {
				returnVal = 100;

			}

		}

		logger.info("getCaseSearchCount ::" + countResults);

		return returnVal;

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Case getCaseDetail(double caseId) {
		
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Case where IdCase=:IdCase");
			query.setDouble("IdCase", caseId);
			
			Case caseFound =(Case) query.uniqueResult();

			logger.info("getCaseDetail ::" + caseFound);
			
			if (caseFound!=null)
			{
			caseFound.setVisitorCount(caseFound.getVisitorCount()+1);
			
			session.update(caseFound);
			}
			
			return caseFound;
			
		} catch (HibernateException e) {
			logger.error("getCaseDetail ::" + e.getMessage());
		return null;
		}
		
		


	}


	@SuppressWarnings("unchecked")
	@Override
	public List<CaseSearch> listSaleCase() {

		
		//persian date
		PersianCalendar persianCalendar1 = new PersianCalendar(new Date());
		String year=String.valueOf(persianCalendar1.get(Calendar.YEAR));
		
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery("from CaseSearch where pic1 like 'http%' and DateIn like :dateIN  ORDER BY RAND()");

		
		query.setString("dateIN", year+"%");
		query.setMaxResults(3);
		List<CaseSearch> listSaleCase = query.list();
		for (CaseSearch p : listSaleCase) {
			logger.info("Case listSaleCase:" + p);
		}
		return listSaleCase;

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Case> listSimilarCase(Case caseObj) {

		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder strQuery = new StringBuilder();

		strQuery.append("from Case where pic1 like 'http%' and ");

		if (caseObj.getKindRequest() != null) {
			strQuery.append("IdKindRequest=:IdKindRequest  ");
		}

		if (caseObj.getKindCase() != null) {
			strQuery.append("and  IdKindCase=:IdKindCase ");
		}

		if (caseObj.getState() != null) {
			strQuery.append("and  IdState=:IdState  ");
		}

		if (caseObj.getCity() != null) {
			strQuery.append("and IdCity=:IdCity  ");
		}

		if (caseObj.getArea() != null) {
			strQuery.append("and  IdArea=:IdArea  ");
		}

		if (caseObj.getRange() != null) {
			strQuery.append("and  IdRange=:IdRange ");
		}

		strQuery.append("ORDER BY RAND() ");

		Query query = session.createQuery(strQuery.toString());

		if (caseObj.getKindRequest() != null) {
			query.setDouble("IdKindRequest", caseObj.getKindRequest().getIdKindRequest());
		}

		if (caseObj.getKindCase() != null) {
			query.setDouble("IdKindCase", caseObj.getKindCase().getIdKindCase());
		}

		if (caseObj.getState() != null) {
			query.setDouble("IdState", caseObj.getState().getIdState());
		}

		if (caseObj.getCity() != null) {

			query.setDouble("IdCity", caseObj.getCity().getIdCity());
		}

		if (caseObj.getArea() != null) {

			query.setDouble("IdArea", caseObj.getArea().getIdArea());
		}

		if (caseObj.getRange() != null) {

			query.setDouble("IdRange", caseObj.getRange().getIdRange());
		}

		query.setMaxResults(3);
		List<Case> listSimilarCase = query.list();
		for (Case p : listSimilarCase) {
			logger.info("Case listSimilarCase:" + p);
		}
		return listSimilarCase;

	}
	
	

	@Override
	public double getCaseMax() {
		Double returnVal ;
		
		Session session = this.sessionFactory.getCurrentSession();

		StringBuilder strQuery = new StringBuilder();

		strQuery.append("Select max (Id) from CaseSearch ");
		
		Query query = session.createQuery(strQuery.toString());

		returnVal = (Double) query.uniqueResult();

		logger.info("getCaseMax ::" + returnVal);

		return returnVal;
	}
	
	
	@Override
	public boolean SaveCase(Case caseObj) {
		
		Transaction tx1=null;
		Session sessionUser=null;
		try {
		
		
		//user Max
		Session session = this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("select max(id)+1 from Users");
		String idmax =query.uniqueResult().toString();
		session.flush();
		

		//Set Max Id in user
		caseObj.getUsers().setIdUser(idmax);
		
		
		sessionUser = this.sessionFactory.openSession();
	    tx1 = sessionUser.beginTransaction();
	    
	    	Users user=caseObj.getUsers();
			sessionUser.save(user);
			
		
			sessionUser.save(caseObj);
		
			
		
		tx1.commit();
		sessionUser.close();
		
		logger.info("SaveCase ::" + caseObj.getIdCase());
	
		
			return true;
			
		} catch (Exception e) {
		
			if (sessionUser.isOpen())
			{
			tx1.rollback();
			sessionUser.close();
			}
			logger.error("SaveCase Error ::" + caseObj.getIdCase() + " " + e.getLocalizedMessage());
			return false;
		}
	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseAdmin> LastlistCase(int count) {
		Session session = this.sessionFactory.getCurrentSession();

		
		TypedQuery<CaseAdmin> query = session.createQuery("from CaseAdmin" 
				//+" "
				//+" where  Case.Users.EmailAdd != '' or Case.Users.Family != ''"
				+" order by intDayOn desc");
		
		
		
		
		query.setMaxResults(count);
		List<CaseAdmin> caseList = query.getResultList();
		

		
		for (CaseAdmin p : caseList) {
		
			logger.info("Case LastlistCase::" + p);
			
		}
		return caseList;
	}
	
	
	

	// making query
	private void SearchQueryMake(Case caseObj, CaseAdSearch caseAd, StringBuilder strQuery) {

		if (caseObj.getKindRequest() != null) {
			strQuery.append("IdKindRequest=:IdKindRequest  ");
		}

		if (caseObj.getKindCase() != null) {
			strQuery.append("and  IdKindCase=:IdKindCase ");
		}

		if (caseObj.getState() != null) {
			strQuery.append("and  IdState=:IdState  ");
		}

		if (caseObj.getCity() != null) {
			strQuery.append("and IdCity=:IdCity  ");
		}

		if (caseObj.getArea() != null) {
			strQuery.append("and  IdArea=:IdArea  ");
		}

		if (caseObj.getRange() != null) {
			strQuery.append("and  IdRange=:IdRange ");
		}

		if (caseAd != null) {
			if (caseAd.isNegahban() == true) {
				strQuery.append("and  Negahban=:Negahban ");
			}

			
			if (caseAd.isDoor() == true) {
				strQuery.append("and  Door=:Door ");
			}

			if (caseAd.isElevator() == true) {
				strQuery.append("and  Elevator=:Elevator ");
			}

			if (caseAd.isIphone() == true) {
				strQuery.append("and  Iphone=:Iphone ");
			}

			if (caseAd.isParking() == true) {
				strQuery.append("and  Parking=:Parking ");
			}

			if (caseAd.isPasio() == true) {
				strQuery.append("and  Pasio=:Pasio ");
			}
			
			if (caseAd.isStorage() == true) {
				strQuery.append("and  Storage=:Storage ");
			}

			if (caseAd.isPool() == true) {
				strQuery.append("and  Pool=:Pool ");
			}

			if (caseAd.isWithPicture() == true) {
				strQuery.append("and  pic1 like :pic1 ");
			}

			if (caseAd.getCabinet() != null) {
				if (caseAd.getCabinet().getfID()!=87 )
				{
				strQuery.append("and  KindCabinet=:KindCabinet ");
				}
			}

			if (caseAd.getNama() != null) {
				if (caseAd.getNama().getfID()!=87 )
				{
				strQuery.append("and  nama=:Nama ");
				}
			}

			if (caseAd.getRoof() != null) {
				if (caseAd.getRoof().getfID()!=87 )
				{
				strQuery.append("and  KindRoof=:KindRoof ");
				}
			}

			if (caseAd.getFromAge() != null && caseAd.getTillAge() != null) {
				if ((!caseAd.getFromAge().isEmpty()) && (!caseAd.getTillAge().isEmpty())) {
					strQuery.append("and (Age>= :FromAge and Age<= :TillAge) ");

				}
			}

			if (caseAd.getTillPrice1() != null && caseAd.getTillPrice1() != null) {
				if ((!caseAd.getFromPrice1().isEmpty()) && (!caseAd.getTillPrice1().isEmpty())) {
					strQuery.append("and (Price1 >= :FromPrice1 and Price1<= :TillPrice1) ");

				}
			}

			if (caseAd.getFromPrice2() != null && caseAd.getTillPrice1() != null) {
				if ((!caseAd.getFromPrice2().isEmpty()) && (!caseAd.getTillPrice2().isEmpty())) {
					strQuery.append("and (Price2 >= :FromPrice2 and Price2<= :TillPrice2) ");
				}
			}

			if (caseAd.getFromMetraj() != null && caseAd.getTillMetraj() != null) {
				if ((!caseAd.getFromMetraj().isEmpty()) && (!caseAd.getTillMetraj().isEmpty())) {
					strQuery.append("and (Metraj >= :FromMetraj and Metraj<= :TillMetraj) ");
				}
			}

			if (caseAd.getFromCountbed() != null && caseAd.getTillCountbed() != null) {
				if ((!caseAd.getFromCountbed().isEmpty()) && (!caseAd.getTillCountbed().isEmpty())) {
					strQuery.append("and (Countbed >= :FromCountbed and Countbed<= :TillCountbed) ");
				}
			}
			

			if (caseAd.isRecently() == true) {
				
				
				strQuery.append("and  Negahban=:Negahban ");
			}
		}

	}

	// making paramter
	private void SearchQueryParamterMake(Case caseObj, CaseAdSearch caseAd, Query query) {

		if (caseObj.getKindRequest() != null) {
			query.setDouble("IdKindRequest", caseObj.getKindRequest().getIdKindRequest());
		}

		if (caseObj.getKindCase() != null) {
			query.setDouble("IdKindCase", caseObj.getKindCase().getIdKindCase());
		}

		if (caseObj.getState() != null) {
			query.setDouble("IdState", caseObj.getState().getIdState());
		}

		if (caseObj.getCity() != null) {

			query.setDouble("IdCity", caseObj.getCity().getIdCity());
		}

		if (caseObj.getArea() != null) {

			query.setDouble("IdArea", caseObj.getArea().getIdArea());
		}

		if (caseObj.getRange() != null) {

			query.setDouble("IdRange", caseObj.getRange().getIdRange());
		}

		if (caseAd != null) {

			if (caseAd.isNegahban() == true) {

				query.setBoolean("Negahban", caseAd.isNegahban());
			}

			if (caseAd.isDoor() == true) {

				query.setBoolean("Door", caseAd.isDoor());
			}

			if (caseAd.isElevator() == true) {

				query.setBoolean("Elevator", caseAd.isElevator());
			}

			if (caseAd.isIphone() == true) {

				query.setBoolean("Iphone", caseAd.isIphone());
			}

			if (caseAd.isParking() == true) {

				query.setBoolean("Parking", caseAd.isParking());
			}

			if (caseAd.isPasio() == true) {

				query.setBoolean("Pasio", caseAd.isPasio());
			}

			if (caseAd.isStorage() == true) {
				query.setBoolean("Storage", caseAd.isStorage());
			}
			
			if (caseAd.isPool() == true) {

				query.setBoolean("Pool", caseAd.isPool());
			}

			if (caseAd.isWithPicture() == true) {
				query.setString("pic1", "http%");
			}

			if (caseAd.getCabinet() != null) {
				if (caseAd.getCabinet().getfID()!=87 )
				{
				query.setDouble("KindCabinet", caseAd.getCabinet().getfID());
				}
			}

			if (caseAd.getNama() != null) {
				if (caseAd.getNama().getfID()!=87 )
				{
				query.setDouble("Nama", caseAd.getNama().getfID());
				}

			}

			if (caseAd.getRoof() != null) {
				if (caseAd.getRoof().getfID()!=87 )
				{
				query.setDouble("KindRoof", caseAd.getRoof().getfID());
				}
			}

			if (caseAd.getFromAge() != null && caseAd.getTillAge() != null) {
				if ((!caseAd.getFromAge().isEmpty()) && (!caseAd.getTillAge().isEmpty())) {
					query.setString("FromAge", caseAd.getFromAge());
					query.setString("TillAge", caseAd.getTillAge());

				}
			}

			if (caseAd.getFromPrice1() != null && caseAd.getTillPrice1() != null) {
				if ((!caseAd.getFromPrice1().isEmpty()) && (!caseAd.getTillPrice1().isEmpty())) {
					query.setString("FromPrice1", caseAd.getFromPrice1());
					query.setString("TillPrice1", caseAd.getTillPrice1());

				}
			}

			if (caseAd.getFromPrice2() != null && caseAd.getTillPrice2() != null) {
				if ((!caseAd.getFromPrice2().isEmpty()) && (!caseAd.getTillPrice2().isEmpty())) {

					query.setString("FromPrice2", caseAd.getFromPrice2());
					query.setString("TillPrice2", caseAd.getTillPrice2());
				}
			}

			if (caseAd.getFromMetraj() != null && caseAd.getTillMetraj() != null) {
				if ((!caseAd.getFromMetraj().isEmpty()) && (!caseAd.getTillMetraj().isEmpty())) {
					query.setInteger("FromMetraj", Integer.parseInt(caseAd.getFromMetraj()));
					query.setInteger("TillMetraj", Integer.parseInt(caseAd.getTillMetraj()));
				}
			}

			if (caseAd.getFromCountbed() != null && caseAd.getTillCountbed() != null) {
				if ((!caseAd.getFromCountbed().isEmpty()) && (!caseAd.getTillCountbed().isEmpty())) {
					query.setInteger("FromCountbed", Integer.parseInt(caseAd.getFromCountbed()));
					query.setInteger("TillCountbed", Integer.parseInt(caseAd.getTillCountbed()));
				}
			}
		}
	}




	



}
