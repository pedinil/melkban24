package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblGallery")
public class Galary {

	
	@Id
	@Column(name="IdGallery")
	private double IdKindGallery;
	
	@Column(name="NameGallery")
	private String NameGallery;
	
	@Column(name="ImageGallery")
	private String ImageGallery;
	
	@Column(name="KindGallery")
	private String KindGallery;
	
	public double getIdKindGallery() {
		return IdKindGallery;
	}

	public void setIdKindGallery(double idKindGallery) {
		IdKindGallery = idKindGallery;
	}

	public String getNameGallery() {
		return NameGallery;
	}

	public void setNameGallery(String nameGallery) {
		NameGallery = nameGallery;
	}

	public String getImageGallery() {
		return ImageGallery;
	}

	public void setImageGallery(String imageGallery) {
		ImageGallery = imageGallery;
	}

	public String getKindGallery() {
		return KindGallery;
	}

	public void setKindGallery(String kindGallery) {
		KindGallery = kindGallery;
	}

	@Override
	public String toString(){
		return "id="+IdKindGallery+", name="+ImageGallery+", imageGallery="+ImageGallery;
	}


	
	
	

	
	
}
