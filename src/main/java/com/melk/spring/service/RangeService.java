package com.melk.spring.service;

import java.util.List;


import com.melk.spring.model.Range;

public interface RangeService {
	
	public List<Range> listRange();
	
	public List<Range> listRangeByArea(double IdArea);
	
	public Range getRangeId(String RangeName,double IdArea);
	


}
