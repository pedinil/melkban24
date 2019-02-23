package com.melk.spring.service;

import java.util.List;

import com.melk.spring.model.News;



public interface NewsService {

	public List<News> listNews(int pageNo);
	
	public List<News> listNewsWithMaxNo(int count);
	
	public News getNewsByID(double newsID);
	
	public int getNewsCount();
	
	public double getNewsMax();
	
	//save to DB
	public boolean SaveNews(News newsObj);
	
	//Update to DB
	public boolean UpdateNews(News newsObj);
	
	//Delete from DB
	public boolean DeleteNews(News newsObj);
	
	
	//search by keyword
	public List<News> listNewsSearch(String keyword);
	
}
