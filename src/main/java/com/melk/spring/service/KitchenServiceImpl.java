package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.KitchenDAO;
import com.melk.spring.model.Kitchen;

public class KitchenServiceImpl implements KitchenService {

	private KitchenDAO kitchenDAO;
	
	public void setKitchenDAO(KitchenDAO kitchenDAO) {
		this.kitchenDAO = kitchenDAO;
	}
	
	@Override
	@Cacheable("listKitchen")
	public List<Kitchen> listKitchen() {
		return this.kitchenDAO.listKitchen();
	}

	
	

}
