package com.melk.spring.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.melk.spring.model.Users;

@Entity
@Table(name="TblCase")
public class CaseAdmin{
	

	
	@Id
	@Column(name="IdCase")
	private double IdCase;

	
	
	
	
	
	

	
	@Column(name="CountPoint")
	private Integer CountPoint;
	

	@Column(name="intDayOn")
	private Double intDayOn;
	

	



	@Column(name="Pic1")
	private String Pic1;
	

	
	
	
	
	@Column(name="DateIn")
	private String DateIn;
	
	
	
	




	@Column(name="IdAgency")
	private String IdAgency;
	


	
	

	
	@ManyToOne
    @JoinColumn(name = "IdUsers")
	private Users users;
	
	
	
	
	
	
	
	
	



	

	public double getIdCase() {
		return IdCase;
	}



	public void setIdCase(double idCase) {
		IdCase = idCase;
	}


	


	


	public Integer getCountPoint() {
		return CountPoint;
	}


	public void setCountPoint(Integer countPoint) {
		CountPoint = countPoint;
	}


	public double getIntDayOn() {
		return intDayOn;
	}


	public void setIntDayOn(double intDayOn) {
		this.intDayOn = intDayOn;
	}




	
	
	
	public String getPic1() {
	
		return Pic1;
	}


	public void setPic1(String pic1) {
		Pic1 = pic1;
		 
	}
	
	@Transient
	public String getThPic1() {
		 
		String thPic1="";
		if (Pic1 !=null)
		  {
			thPic1 =Pic1.replace("AdminAdver", "th-AdminAdver").replace("http://melkban24.ir", "");
		  }
		return thPic1;
	}






	public String getDateIn() {
		return DateIn;
	}


	public void setDateIn(String dateIn) {
		DateIn = dateIn;
	}


	

	
	


	


	


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	
	public String getIdAgency() {
		return IdAgency;
	}


	public void setIdAgency(String idAgency) {
		IdAgency = idAgency;
	}
	
	@Override
	public String toString(){
		return "adminCase caseID="+IdCase+",  DateIn="+DateIn;
	}
	
}
