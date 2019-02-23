package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TblNews")
public class News {
	
	
	@Id
	@Column(name="IdNews")
	private Double IdNews;
	
	@Column(name="DateNews")
	private String DateNews;
	
	@Column(name="AbsNews")
	private String AbsNews;
	
	@Column(name="SubjectNews")
	private String SubjectNews;
	
	@Column(name="BodyNews")
	private String BodyNews;
	
	@Column(name="ImageNews")
	private String ImageNews;
	
	
	

	
	public Double getIdNews() {
		return IdNews;
	}

	public void setIdNews(Double idNews) {
		IdNews = idNews;
	}

	public String getDateNews() {
		return DateNews;
	}

	public void setDateNews(String dateNews) {
		DateNews = dateNews;
	}

	public String getAbsNews() {
		return AbsNews;
	}

	public void setAbsNews(String absNews) {
		AbsNews = absNews;
	}

	public String getSubjectNews() {
		return SubjectNews;
	}

	public void setSubjectNews(String subjectNews) {
		SubjectNews = subjectNews;
	}

	public String getBodyNews() {
		return BodyNews;
	}

	public void setBodyNews(String bodyNews) {
		BodyNews = bodyNews;
	}

	public String getImageNews() {
		return ImageNews;
	}

	public void setImageNews(String imageNews) {
		ImageNews = imageNews;
	}

	@Transient
	public String getURL()
	{
		return SubjectNews.replace(" ", "-");
		
	}
	
	@Transient
	public String getThImagenews() {
		 
		String thImagenews="";
		if (ImageNews !=null)
		  {
			thImagenews =ImageNews.replace("News", "th-News").replace("http://melkban24.ir", "");
		  }
		return thImagenews;
	}
	
	

	@Transient
	public String getNewBodyNOhtml()
	{
		String NewBodyNOhtml="";
		if (BodyNews !=null)
		  {
			NewBodyNOhtml =BodyNews.replaceAll("\\<.*?>","");
			if (NewBodyNOhtml.length()>400)
			{
				NewBodyNOhtml=NewBodyNOhtml.substring(0, 400);
			}
			else
			{
				NewBodyNOhtml=NewBodyNOhtml.substring(0, NewBodyNOhtml.length());
			}
		  }
		
		return NewBodyNOhtml;
		
	}
	
	@Override
	public String toString(){
		return "id="+IdNews+", DateNews="+DateNews+", SubjectNews="+SubjectNews+"ImageNews="+ImageNews;
	}
	
	
	
}
