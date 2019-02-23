package com.melk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TblCase")
public class CaseSearch {

	
	@Column(name="Id")
	private double Id;
	
	
	

	@Column(name="Metraj")
	private double Metraj;
	

	@Column(name="Floor")
	private String Floor;
	
	
	@Column(name="Price1")
	private Double Price1;
	
	@Column(name="Price2")
	private Double Price2;
	
	@Column(name="CountBed")
	private Double CountBed;
	
	@Column(name="Pic1")
	private String Pic1;
	
	@Column(name="Age")
	private String Age;
	
	@Column(name="Gas")
	private boolean Gas;
	
	@Column(name="Elevator")
	private boolean Elevator;
	
	@Column(name="Confine")
	private String Confine;
	
	@Column(name="Parking")
	private boolean Parking;
	
	@Column(name="Furned")
	private boolean Furned;


	@Column(name="Storage")
	private boolean Storage;
	
	//سرایدار
	@Column(name="Negahban")
	private boolean Negahban;
	
	

	//شومینه
	@Column(name="Shomineh")
	private boolean Shomineh;
	
	@Column(name="Door")
	private boolean Door;
	
	
	@Column(name="Iphone")
	private boolean Iphone;
	

	@Column(name="Pasio")
	private boolean Pasio;
	
	//استخر
	@Column(name="Pool")
	private boolean Pool;

	@Column(name="intDayOn")
	private double intDayOn;
	
	
	@ManyToOne
    @JoinColumn(name = "IdKindRequest")
	private KindRequest kindRequest;
	
	@ManyToOne
    @JoinColumn(name = "IdKindCase")
	private KindCase KindCase;
	
	@ManyToOne
    @JoinColumn(name = "IdArea")
	private Area area;
	
	
	

	@ManyToOne
    @JoinColumn(name = "IdRange")
	private Range range;
	
	
	@ManyToOne
    @JoinColumn(name = "IdCity")
 	private City city;
	
	@ManyToOne
    @JoinColumn(name = "IdState")
 	private State state;



	@ManyToOne
    @JoinColumn(name = "KindRoof")
	private Roof roof;
	
	


	@ManyToOne
    @JoinColumn(name = "Nama")
 	private Nama nama;
	
	@ManyToOne
    @JoinColumn(name = "KindCabinet")
	private Cabinet cabinet;
	


	@Column(name="DateIn")
	private String DateIn;
	
	@Id
	@Column(name="IdCase")
	private double IdCase;
	
	
	
	public double getId() {
		return Id;
	}

	public void setId(double id) {
		Id = id;
	}
	
	public double getIdCase() {
		return IdCase;
	}

	public void setIdCase(double idCase) {
		IdCase = idCase;
	}

	
	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}
	
	
	public double getMetraj() {
		return Metraj;
	}

	public void setMetraj(double metraj) {
		Metraj = metraj;
	}

	public Double getPrice1() {
		return Price1;
	}

	public void setPrice1(Double price1) {
		Price1 = price1;
	}

	public Double getPrice2() {
		return Price2;
	}

	public void setPrice2(Double price2) {
		Price2 = price2;
	}

	public Double getCountBed() {
		return CountBed;
	}

	public void setCountBed(Double countBed) {
		CountBed = countBed;
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
	

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public boolean isGas() {
		return Gas;
	}

	public void setGas(boolean gas) {
		Gas = gas;
	}

	public boolean isElevator() {
		return Elevator;
	}

	public void setElevator(boolean elevator) {
		Elevator = elevator;
	}

	public String getConfine() {
		return Confine;
	}

	public void setConfine(String confine) {
		Confine = confine;
	}

	public double getIntDayOn() {
		return intDayOn;
	}

	public void setIntDayOn(double intDayOn) {
		this.intDayOn = intDayOn;
	}
	
	public KindRequest getKindRequest() {
		return kindRequest;
	}

	public void setKindRequest(KindRequest kindRequest) {
		this.kindRequest = kindRequest;
	}

	public KindCase getKindCase() {
		return KindCase;
	}

	public void setKindCase(KindCase kindCase) {
		KindCase = kindCase;
	}

	

	public boolean isFurned() {
		return Furned;
	}

	public void setFurned(boolean furned) {
		Furned = furned;
	}
	
	public boolean isParking() {
		return Parking;
	}

	public void setParking(boolean parking) {
		Parking = parking;
	}
	
	public boolean isNegahban() {
		return Negahban;
	}

	public void setNegahban(boolean negahban) {
		Negahban = negahban;
	}

	public boolean isShomineh() {
		return Shomineh;
	}

	public void setShomineh(boolean shomineh) {
		Shomineh = shomineh;
	}

	public boolean isDoor() {
		return Door;
	}

	public void setDoor(boolean door) {
		Door = door;
	}

	public boolean isIphone() {
		return Iphone;
	}

	public void setIphone(boolean iphone) {
		Iphone = iphone;
	}

	public boolean isPasio() {
		return Pasio;
	}

	public void setPasio(boolean pasio) {
		Pasio = pasio;
	}

	public boolean isPool() {
		return Pool;
	}

	public void setPool(boolean pool) {
		Pool = pool;
	}
	
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	
	public boolean isStorage() {
		return Storage;
	}

	public void setStorage(boolean storage) {
		Storage = storage;
	}
	
	public String getDateIn() {
		return DateIn;
	}

	public void setDateIn(String dateIn) {
		DateIn = dateIn;
	}
	
	
	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	public Roof getRoof() {
		return roof;
	}

	public void setRoof(Roof roof) {
		this.roof = roof;
	}
	
	
	public Nama getNama() {
		return nama;
	}

	public void setNama(Nama nama) {
		this.nama = nama;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}
	
	@Override
	public String toString(){
		return "caseID="+IdCase+", Price1="+Price1+", Price2="+Price2+",intDayOn="+intDayOn +",dateIn="+DateIn ;
	}
	
	

	
}
