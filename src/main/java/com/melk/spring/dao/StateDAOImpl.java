package com.melk.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.model.KindCase;
import com.melk.spring.model.State;


@Repository
@Transactional
public class StateDAOImpl implements StateDAO {


	private static final Logger logger = LoggerFactory.getLogger(StateDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<State> listState() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<State> stateList= session.createQuery("from State").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(State p : stateList){
			logger.info("Stats List::"+p);
		}
		return stateList;
	}

	@Override
	public State getStateId(String NameState) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query= session.createQuery("from State where NameState like :NameState");
		 query.setString("NameState", NameState );
		 State state=(State)query.uniqueResult();
		 
		 logger.info("getStateId :"+state);
		 
		 return state;
		 
		 
	}

}
