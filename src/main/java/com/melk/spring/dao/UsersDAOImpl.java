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

import com.melk.spring.model.Users;

@Repository
@Transactional
public class UsersDAOImpl implements UsersDAO {

	private static final Logger logger = LoggerFactory.getLogger(UsersDAOImpl.class);

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();	
		List<Users> usersList= session.createQuery("from Users").list();
		/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
		query.addEntity(Users.class);
		List<Users> usersList=query.list();*/
		for(Users p : usersList){
			logger.info("Users List::"+p);
		}
		return usersList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> CheckUserPass(Users user) {
		
		logger.debug("Try:CheckUserPass:"+user);
		
		if (user!=null)
		{
			Session session = this.sessionFactory.getCurrentSession();
			Query query= session.createQuery("from Users IdUser=:IdUser and Pass=:Pass");
		
			query.setString("IdUser", user.getIdUser() );
			query.setString("Pass", user.getPass());
			List<Users> usersList=query.list();
			/*SQLQuery query = session.createSQLQuery("select * from TblUser limit 10");
			query.addEntity(Users.class);
			List<Users> usersList=query.list();*/
			for(Users p : usersList){
				logger.info("CheckUserPass:"+p);
			}
			return usersList;
		}
	return null;
	}


	@Override
	public Users findByIdUser(String idUser) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Users WHERE IdUser=:IdUser");
		query.setString("IdUser", idUser);
		Users users=(Users)query.uniqueResult();
		
		logger.info("User :"+users);
		return users;
	}


	@Override
	public boolean SaveUser(Users user) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("select max(id)+1 from Users");
		String idmax =query.uniqueResult().toString();
		
		session.flush();
		
		//String idmax ="95245911";
		
		Transaction tx1 = session.beginTransaction();
		Session session1 = sessionFactory.openSession();
		
		
		user.setIdUser(idmax);
		session1.save(user);
		tx1.commit();
		
		logger.info("SaveCase ::" + user);
		
		return true;
	}
	
}
