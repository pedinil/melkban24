package com.melk.spring.service;

import java.util.List;

import com.melk.spring.model.Users;

public interface UsersService {

	public List<Users> listUsers();
	
	public List<Users> CheckUserPass(Users user);
	
	public Users findByIdUser(String idUser);
	
	public boolean SaveUser(Users user);
	
}
