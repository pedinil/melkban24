package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


public class CaseAdSearch {

	
	
	
	


	private String FromMetraj;
	
	




	private String TillMetraj;
	
	
	private String FromPrice1;
	
	private String TillPrice1;
	
	
	private String FromPrice2;
	
	private String TillPrice2;
	
	
	private String FromAge;
	
	private String TillAge;
	
	
	private String FromCountbed;
	
	private String TillCountbed;
	
	
	private boolean WithPicture;
	
	private boolean Recently;
	
	private boolean Parking;
	
	
	private boolean Pool;
	
	
	private boolean Door;
	
	
	private boolean Pasio;
	
	private boolean Elevator;
	
	
	private boolean Negahban;
	
	
	private boolean Iphone;
	
	private boolean Storage;
	




	private Roof roof;
	
	private Cabinet cabinet;
	
 	private Nama nama;
 	
 	
 


 	public String getFromMetraj() {
		return FromMetraj;
	}










	public void setFromMetraj(String fromMetraj) {
		FromMetraj = fromMetraj;
	}










	public String getTillMetraj() {
		return TillMetraj;
	}










	public void setTillMetraj(String tillMetraj) {
		TillMetraj = tillMetraj;
	}










	public String getFromPrice1() {
		return FromPrice1;
	}










	public void setFromPrice1(String fromPrice1) {
		FromPrice1 = fromPrice1;
	}










	public String getTillPrice1() {
		return TillPrice1;
	}










	public void setTillPrice1(String tillPrice1) {
		TillPrice1 = tillPrice1;
	}










	public String getFromPrice2() {
		return FromPrice2;
	}










	public void setFromPrice2(String fromPrice2) {
		FromPrice2 = fromPrice2;
	}










	public String getTillPrice2() {
		return TillPrice2;
	}










	public void setTillPrice2(String tillPrice2) {
		TillPrice2 = tillPrice2;
	}










	public String getFromAge() {
		return FromAge;
	}










	public void setFromAge(String fromAge) {
		FromAge = fromAge;
	}










	public String getTillAge() {
		return TillAge;
	}










	public void setTillAge(String tillAge) {
		TillAge = tillAge;
	}










	public String getFromCountbed() {
		return FromCountbed;
	}










	public void setFromCountbed(String fromCountbed) {
		FromCountbed = fromCountbed;
	}










	public String getTillCountbed() {
		return TillCountbed;
	}










	public void setTillCountbed(String tillCountbed) {
		TillCountbed = tillCountbed;
	}







	public boolean isWithPicture() {
		return WithPicture;
	}










	public void setWithPicture(boolean withPicture) {
		WithPicture = withPicture;
	}










	public boolean isRecently() {
		return Recently;
	}










	public void setRecently(boolean recently) {
		Recently = recently;
	}










	public boolean isParking() {
		return Parking;
	}










	public void setParking(boolean parking) {
		Parking = parking;
	}










	public boolean isPool() {
		return Pool;
	}










	public void setPool(boolean pool) {
		Pool = pool;
	}










	public boolean isDoor() {
		return Door;
	}










	public void setDoor(boolean door) {
		Door = door;
	}










	public boolean isPasio() {
		return Pasio;
	}










	public void setPasio(boolean pasio) {
		Pasio = pasio;
	}










	public boolean isElevator() {
		return Elevator;
	}










	public void setElevator(boolean elevator) {
		Elevator = elevator;
	}










	public boolean isNegahban() {
		return Negahban;
	}










	public void setNegahban(boolean negahban) {
		Negahban = negahban;
	}









	
	public Roof getRoof() {
		return roof;
	}


	public void setRoof(Roof roof) {
		this.roof = roof;
	}


	public Cabinet getCabinet() {
		return cabinet;
	}


	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}


	public Nama getNama() {
		return nama;
	}


	public void setNama(Nama nama) {
		this.nama = nama;
	}


	
	
	
	public boolean isIphone() {
		return Iphone;
	}


	public void setIphone(boolean iphone) {
		Iphone = iphone;
	}


	public boolean isStorage() {
		return Storage;
	}


	public void setStorage(boolean storage) {
		Storage = storage;
	}


	
	
	

	@Override
	public String toString(){
		return "FromMetraj="+FromMetraj+", TillMetraj="+TillMetraj ;
	}
	
	

	
}
