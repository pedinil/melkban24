package com.melk.spring.service;




import java.util.List;

import com.melk.spring.dao.GalaryDAO;
import com.melk.spring.model.Galary;


public class GalaryServiceImpl implements GalaryService {

	private GalaryDAO galaryDAO;
	
	public void setGalaryDAO(GalaryDAO galaryDAO) {
		this.galaryDAO = galaryDAO;
	}

	@Override
	public List<Galary> listGalary(int IdKindGallery) {
		return this.galaryDAO.listGalary(IdKindGallery);
	}
	

	

}
