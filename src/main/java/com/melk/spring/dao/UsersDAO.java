package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.Users;

public interface UsersDAO {

	
	public List<Users> listUsers();

	public List<Users> CheckUserPass(Users user);
	
	public Users findByIdUser(String idUser);
	
	public boolean SaveUser(Users user);
	
}
