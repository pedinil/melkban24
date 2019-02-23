package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="TblUser")
public class Users {

	@Id
	@Column(name="IdUser")
	private String IdUser;
	
	@Column(name="Family")
	private String Family;
	
	@Column(name="Tel")
	private String Tel;
	
	@Column(name="Mobile")
	private String Mobile;
	
	@Column(name="IdAgency")
	private String IdAgency;
	
	@Column(name="Pass")
	private String Pass;
	
	@Column(name="EmailAdd")
	private String EmailAdd;
	
	
	public String getIdUser() {
		return IdUser;
	}




	public void setIdUser(String idUser) {
		IdUser = idUser;
	}




	public String getFamily() {
		return Family;
	}




	public void setFamily(String family) {
		Family = family;
	}




	public String getTel() {
		return Tel;
	}




	public void setTel(String tel) {
		Tel = tel;
	}




	public String getMobile() {
		return Mobile;
	}




	public void setMobile(String mobile) {
		Mobile = mobile;
	}




	public String getIdAgency() {
		return IdAgency;
	}




	public void setIdAgency(String idAgency) {
		IdAgency = idAgency;
	}




	public String getPass() {
		return Pass;
	}




	public void setPass(String pass) {
		Pass = pass;
	}




	public String getEmailAdd() {
		return EmailAdd;
	}




	public void setEmailAdd(String emailAdd) {
		EmailAdd = emailAdd;
	}

	@Override
	public String toString(){
		return "id="+IdUser+", IdAgency="+IdAgency+", EmailAdd="+EmailAdd;
	}

}
