package com.melk.spring.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TblKnow")
public class Know {
	
	@Id 
	@Column(name="IdKnow")
	private double IdKnow;
	
	@Column(name="SubjectKnow")
	private String SubjectKnow;
	
	@Column(name="BodyKnow")
	@Basic(optional = true) 
	private String BodyKnow;
	
	@Column(name="ImgKnow")
	@Basic(optional = true) 
	private String ImgKnow;
	
	@Column(name="CountView")
	@Basic(optional = true) 
	private double CountView;
	
	public double getIdKnow() {
		return IdKnow;
	}

	public void setIdKnow(double idKnow) {
		IdKnow = idKnow;
	}

	public String getSubjectKnow() {
		return SubjectKnow;
	}

	public void setSubjectKnow(String subjectKnow) {
		SubjectKnow = subjectKnow;
	}

	public String getBodyKnow() {
		return BodyKnow;
	}

	public void setBodyKnow(String bodyKnow) {
		BodyKnow = bodyKnow;
	}

	public String getImgKnow() {
		return ImgKnow;
	}

	public void setImgKnow(String imgKnow) {
		ImgKnow = imgKnow;
	}

	public double getCountView() {
		return CountView;
	}

	public void setCountView(double countView) {
		CountView = countView;
	}

	@Transient
	public String getURL()
	{
		return SubjectKnow.replace(" ", "-");
		
	}
	
	

	@Transient
	public String getKnowBodyNOhtml()
	{
		String KnowBodyNOhtml="";
		if (BodyKnow !=null)
		  {
			KnowBodyNOhtml =BodyKnow.replaceAll("\\<.*?>","");
			if (KnowBodyNOhtml.length()>400)
			{
				KnowBodyNOhtml=KnowBodyNOhtml.substring(0, 400);
			}
			else
			{
				KnowBodyNOhtml=KnowBodyNOhtml.substring(0, KnowBodyNOhtml.length());
			}
		  }
		
		return KnowBodyNOhtml;
		
	}
	
	
	@Override
	public String toString(){
		return "id="+IdKnow+", SubjectKnow="+SubjectKnow+", ImgKnow="+ImgKnow + ", CountView="+CountView;
	}

}
