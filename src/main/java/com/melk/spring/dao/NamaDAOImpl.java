package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.Nama;


@Repository
@Transactional
public class NamaDAOImpl implements NamaDAO{
	
	
	
private static final Logger logger = LoggerFactory.getLogger(NamaDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nama> listNama() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Nama> namaList= session.createQuery("from Nama order by namaName ").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Nama p : namaList){
			logger.info("Nama List::"+p);
		}
		return namaList;
	}



}
