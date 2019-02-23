package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.NamaDAO;
import com.melk.spring.model.Nama;

public class NamaServiceImpl implements NamaService {

	private NamaDAO namaDAO;
	
	public void setNamaDAO(NamaDAO namaDAO) {
		this.namaDAO = namaDAO;
	}
	
	@Override
	@Cacheable("listNama")
	public List<Nama> listNama() {
		return this.namaDAO.listNama();
	}

	
	

}
