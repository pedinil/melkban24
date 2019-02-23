package com.melk.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.melk.spring.dao.UsersDAO;
import com.melk.spring.model.Users;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	
	//get user from the database, via Hibernate
	@Autowired(required=true)
	@Qualifier(value="UsersDAO")
	private UsersDAO usersDao;
	
	public void setUsersDAO(UsersDAO ps){
		this.usersDao = ps;
	}
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String idUser) throws UsernameNotFoundException{
		Users user=usersDao.findByIdUser(idUser);
		if(user==null)
			throw new UsernameNotFoundException("User Not Found!");
		return new User(user.getIdUser(), user.getPass(), true, true, true, true, getGrantedAuthority(user));
		
	}
	private List<GrantedAuthority> getGrantedAuthority(Users users){
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		return authorities;		
		
	}
}