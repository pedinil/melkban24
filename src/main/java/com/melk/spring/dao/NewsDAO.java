package com.melk.spring.dao;

import java.util.List;


import com.melk.spring.model.News;



public interface NewsDAO {
	
	public List<News> listNews(int RowCount);
	
	public List<News> listNewsWithMaxNo(int count);
	
	public News getNewsByID(double newsID);
	
	public int getNewsCount();
	
	public double getNewsMax();

	//save to DB
	public boolean SaveNews(News newsObj);
	
	//update to DB
	public boolean UpdateNews(News newsObj);
	
	//Delete from DB
	public boolean DeleteNews(News newsObj);
	
	//search by keyword
	public List<News> listNewsSearch(String keyword);
}
