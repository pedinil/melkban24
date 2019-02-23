package com.melk.spring.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.melk.spring.dao.RangeDAO;
import com.melk.spring.model.Range;

public class RangeServiceImpl implements RangeService {

	private RangeDAO rangeDAO;
	
	public void setRangeDAO(RangeDAO rangeDAO) {
		this.rangeDAO = rangeDAO;
	}

	@Override
	public List<Range> listRange() {
		return this.rangeDAO.listRange();
	}

	@Override
	@Cacheable("listRangeByArea")
	public List<Range> listRangeByArea(double IdArea) {
		return this.rangeDAO.listRangeByArea(IdArea);
	}

	@Override
	@Cacheable("getRangeId")
	public Range getRangeId(String RangeName,double IdArea) {
		return this.rangeDAO.getRangeId(RangeName,IdArea);
	}
	


}
