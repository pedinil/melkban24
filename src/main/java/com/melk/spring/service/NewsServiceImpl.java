package com.melk.spring.service;

import java.util.List;

import com.melk.spring.dao.NewsDAO;
import com.melk.spring.model.News;

public class NewsServiceImpl implements NewsService {

	
	private NewsDAO newsDAO;
	
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}
	
	@Override
	public List<News> listNews(int pageNo) {
		return this.newsDAO.listNews(pageNo);
	}

	@Override
	public News getNewsByID(double newsID) {
		return this.newsDAO.getNewsByID(newsID);
	}

	@Override
	public int getNewsCount() {
		return this.newsDAO.getNewsCount();
	}

	@Override
	public List<News> listNewsWithMaxNo(int count) {
		return this.newsDAO.listNewsWithMaxNo(count);
	}

	@Override
	public double getNewsMax() {
		return this.newsDAO.getNewsMax();
	}

	@Override
	public boolean SaveNews(News newsObj) {
		return this.newsDAO.SaveNews(newsObj);
	}
	
	
	@Override
	public boolean UpdateNews(News newsObj) {
		return this.newsDAO.UpdateNews(newsObj);
	}

	@Override
	public boolean DeleteNews(News newsObj) {
		return this.newsDAO.DeleteNews(newsObj);
	}

	@Override
	public List<News> listNewsSearch(String keyword) {
		return this.newsDAO.listNewsSearch(keyword);
	}

}
