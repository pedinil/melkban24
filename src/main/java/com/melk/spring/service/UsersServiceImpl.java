package com.melk.spring.service;

import java.util.List;

import com.melk.spring.dao.UsersDAO;
import com.melk.spring.model.Users;

public class UsersServiceImpl implements UsersService  {

	private UsersDAO usersDAO;
	
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	
	@Override
	public List<Users> listUsers() {
		return this.usersDAO.listUsers();
	}


	@Override
	public List<Users> CheckUserPass(Users user) {
		return this.usersDAO.CheckUserPass(user);
	}
	
	@Override
	public Users findByIdUser(String idUser){
		return this.usersDAO.findByIdUser(idUser);
	}


	@Override
	public boolean SaveUser(Users user) {
		return this.usersDAO.SaveUser(user);
	}

}
