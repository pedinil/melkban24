package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.Area;
import com.melk.spring.model.Range;



public interface RangeDAO {
	
	public List<Range> listRange();
	
	public List<Range> listRangeByArea(double IdArea);
	
	public Range getRangeId(String RangeName,double IdArea);

}
