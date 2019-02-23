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
public class Case {
	
	
	@Column(name="Id")
	private double Id;
	
	@Id
	@Column(name="IdCase")
	private double IdCase;
	
	@Column(name="Metraj")
	private Double Metraj;
	
	
	@Column(name="Price1")
	private Double Price1;
	
	
	@Column(name="Price2")
	private Double Price2;
	
	
	@Column(name="CountFloor")
	private Double CountFloor;
	
	
	@Column(name="Floor")
	private String Floor;
	
	
	@Column(name="CountUnit")
	private Double CountUnit;
	
	
	@Column(name="Unit")
	private String Unit;

	
	@Column(name="CountBed")
	private Double CountBed;
	
	@Column(name="Parking")
	private boolean Parking;
	
	//انباری
	@Column(name="Storage")
	private boolean Storage;
	
	//آسانسور
	@Column(name="Elevator")
	private boolean Elevator;
	
	//Gas
	@Column(name="Gas")
	private boolean Gas;
	
	//مبله
	@Column(name="Furned")
	private boolean Furned;
	
	@Column(name="Point")
	private Integer Point;
	
	@Column(name="CountPoint")
	private Integer CountPoint;
	

	@Column(name="intDayOn")
	private Double intDayOn;
	

	



	@Column(name="Pic1")
	private String Pic1;
	
	
	@Column(name="Pic2")
	private String Pic2;
	
	@Column(name="Pic3")
	private String Pic3;
	
	@Column(name="Pic4")
	private String Pic4;
	
	@Column(name="Pic5")
	private String Pic5;
	
	@Column(name="Pic6")
	private String Pic6;
	
	@Column(name="Pic7")
	private String Pic7;
	
	@Column(name="Pic8")
	private String Pic8;
	
	@Column(name="Pic9")
	private String Pic9;
	
	@Column(name="Age")
	private String Age;
	
	@Column(name="Confine")
	private String Confine;
	
	@Column(name="Iphone")
	private boolean Iphone;
	
	
	@Column(name="Door")
	private boolean Door;
	
	//استخر
	@Column(name="Pool")
	private boolean Pool;
	
	@Column(name="Comment")
	private String Comment;


	
	@Column(name="Views")
	private double Views;
	
	
	@Column(name="DateIn")
	private String DateIn;
	
	@Column(name="URL")
	private String URL;
	
	@Column(name="VisitorCount")
	private double VisitorCount;
	
	
	
	@Column(name="Masahat")
	private Double Masahat;
	
	//جکوزی
	@Column(name="Sona")
	private boolean Sona;
	
	//شوتینگ زباله
	@Column(name="Shooting")
	private boolean Shooting;
	
	//اطقا حریق
	@Column(name="Fire")
	private boolean Fire;
	
	//لابی
	@Column(name="Loby")
	private boolean Loby;
	
	//پله اظطراری
	@Column(name="Pele")
	private boolean Pele;
	
	//دوربین
	@Column(name="Camera")
	private boolean Camera;
	
	//تلفن
	@Column(name="Tel")
	private boolean Tel;
	
	
	@Column(name="Anten")
	private boolean Anten;
	
	
	@Column(name="Pasio")
	private boolean Pasio;
	
	//تخلیه
	@Column(name="Takhlie")
	private boolean Takhlie;
	
	//سرایدار
	@Column(name="Negahban")
	private boolean Negahban;
	
	//شومینه
	@Column(name="Shomineh")
	private boolean Shomineh;
	
	
	
	@Column(name="Lat",nullable=true)
	private Double Lat;
	
	@Column(name="Lon",nullable=true)
	private Double Lon;




	@Column(name="IdAgency")
	private String IdAgency;
	


	@ManyToOne
	@JoinColumn(name="CaseSide")
	private CaseSide caseSide;
	
	@ManyToOne
    @JoinColumn(name = "Nama")
 	private Nama nama;
	
	
	@ManyToOne
    @JoinColumn(name = "IdArea")
	private Area area;

	
	@ManyToOne
    @JoinColumn(name = "IdRange")
	private Range range;
	
	@ManyToOne
    @JoinColumn(name = "IdKindRequest")
	private KindRequest kindRequest;
	
	
	@ManyToOne
    @JoinColumn(name = "IdKindCase")
	private KindCase KindCase;
	
/*	@ManyToOne
    @JoinColumn(name = "IdAgency")
	private Agency agency;*/
	
	@ManyToOne
    @JoinColumn(name = "IdUsers")
	private Users users;
	
	
	@ManyToOne
    @JoinColumn(name = "KindRoof")
	private Roof roof;
	
  

	@ManyToOne
    @JoinColumn(name = "KindKitchen")
	private Kitchen kitchen;
	
	
	@ManyToOne
    @JoinColumn(name = "windows")
 	private Windows windows;
	
	
	@ManyToOne
    @JoinColumn(name = "kindService")
 	private Service service;
	
	
	@ManyToOne
    @JoinColumn(name = "IdCity")
 	private City city;
	
	
	@ManyToOne
    @JoinColumn(name = "IdState")
 	private State state;
	
	@ManyToOne
    @JoinColumn(name = "Sarmayesh")
	private SystemS systemS;
	
	
	@ManyToOne
    @JoinColumn(name = "Garmayesh")
	private SystemG systemG;

	
	@ManyToOne
    @JoinColumn(name = "KindCabinet")
	private Cabinet cabinet;

	
	



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


	public Double getMetraj() {
		return Metraj;
	}


	public void setMetraj(Double metraj) {
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


	public Double getCountFloor() {
		return CountFloor;
	}


	public void setCountFloor(Double countFloor) {
		CountFloor = countFloor;
	}


	public String getFloor() {
		return Floor;
	}


	public void setFloor(String floor) {
		Floor = floor;
	}


	public Double getCountUnit() {
		return CountUnit;
	}


	public void setCountUnit(Double countUnit) {
		CountUnit = countUnit;
	}


	public String getUnit() {
		return Unit;
	}


	public void setUnit(String unit) {
		Unit = unit;
	}





	public Double getCountBed() {
		return CountBed;
	}


	public void setCountBed(Double countBed) {
		CountBed = countBed;
	}


	public boolean isParking() {
		return Parking;
	}


	public void setParking(boolean parking) {
		Parking = parking;
	}


	public boolean isStorage() {
		return Storage;
	}


	public void setStorage(boolean storage) {
		Storage = storage;
	}


	public boolean isElevator() {
		return Elevator;
	}


	public void setElevator(boolean elevator) {
		Elevator = elevator;
	}


	public boolean isGas() {
		return Gas;
	}


	public void setGas(boolean gas) {
		Gas = gas;
	}


	public boolean isFurned() {
		return Furned;
	}


	public void setFurned(boolean furned) {
		Furned = furned;
	}


	public Integer getPoint() {
		return Point;
	}


	public void setPoint(Integer point) {
		Point = point;
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



	public String getPic2() {
		return Pic2;
	}


	public void setPic2(String pic2) {
		Pic2 = pic2;
	}


	public String getPic3() {
		return Pic3;
	}


	public void setPic3(String pic3) {
		Pic3 = pic3;
	}


	public String getPic4() {
		return Pic4;
	}


	public void setPic4(String pic4) {
		Pic4 = pic4;
	}


	public String getPic5() {
		return Pic5;
	}


	public void setPic5(String pic5) {
		Pic5 = pic5;
	}


	public String getPic6() {
		return Pic6;
	}


	public void setPic6(String pic6) {
		Pic6 = pic6;
	}


	public String getPic7() {
		return Pic7;
	}


	public void setPic7(String pic7) {
		Pic7 = pic7;
	}


	public String getPic8() {
		return Pic8;
	}


	public void setPic8(String pic8) {
		Pic8 = pic8;
	}


	public String getPic9() {
		return Pic9;
	}


	public void setPic9(String pic9) {
		Pic9 = pic9;
	}


	public String getAge() {
		return Age;
	}


	public void setAge(String age) {
		Age = age;
	}


	public String getConfine() {
		return Confine;
	}


	public void setConfine(String confine) {
		Confine = confine;
	}


	public boolean isIphone() {
		return Iphone;
	}


	public void setIphone(boolean iphone) {
		Iphone = iphone;
	}


	public boolean isDoor() {
		return Door;
	}


	public void setDoor(boolean door) {
		Door = door;
	}


	public boolean isPool() {
		return Pool;
	}


	public void setPool(boolean pool) {
		Pool = pool;
	}


	public String getComment() {
		return Comment;
	}


	public void setComment(String comment) {
		Comment = comment;
	}


	public double getViews() {
		return Views;
	}


	public void setViews(double views) {
		Views = views;
	}


	public String getDateIn() {
		return DateIn;
	}


	public void setDateIn(String dateIn) {
		DateIn = dateIn;
	}


	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	}

	
	public CaseSide getCaseSide() {
		return caseSide;
	}


	public void setCaseSide(CaseSide caseSide) {
		this.caseSide = caseSide;
	}
	

	public double getVisitorCount() {
		return VisitorCount;
	}


	public void setVisitorCount(double visitorCount) {
		VisitorCount = visitorCount;
	}


	public Double getMasahat() {
		return Masahat;
	}


	public void setMasahat(Double masahat) {
		Masahat = masahat;
	}


	public boolean isSona() {
		return Sona;
	}


	public void setSona(boolean sona) {
		Sona = sona;
	}


	public boolean isShooting() {
		return Shooting;
	}


	public void setShooting(boolean shooting) {
		Shooting = shooting;
	}

	

	public boolean isFire() {
		return Fire;
	}


	public void setFire(boolean fire) {
		Fire = fire;
	}


	public boolean isLoby() {
		return Loby;
	}


	public void setLoby(boolean loby) {
		Loby = loby;
	}


	public boolean isPele() {
		return Pele;
	}


	public void setPele(boolean pele) {
		Pele = pele;
	}


	public boolean isCamera() {
		return Camera;
	}


	public void setCamera(boolean camera) {
		Camera = camera;
	}


	public boolean isTel() {
		return Tel;
	}


	public void setTel(boolean tel) {
		Tel = tel;
	}


	public boolean isAnten() {
		return Anten;
	}


	public void setAnten(boolean anten) {
		Anten = anten;
	}


	public boolean isPasio() {
		return Pasio;
	}


	public void setPasio(boolean pasio) {
		Pasio = pasio;
	}


	public boolean isTakhlie() {
		return Takhlie;
	}


	public void setTakhlie(boolean takhlie) {
		Takhlie = takhlie;
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
	
	public Double getLat() {
		return Lat;
	}


	public void setLat(Double lat) {
		Lat = (lat==null)?0:lat;
	}


	public Double getLon() {
		return Lon;
	}


	public void setLon(Double lon) {
		Lon = (lon==null)?0:lon;;
	}


	public Nama getNama() {
		return nama;
	}


	public void setNama(Nama nama) {
		this.nama = nama;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public Range getRange() {
		return range;
	}


	public void setRange(Range range) {
		this.range = range;
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


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


    public Roof getRoof() {
		return roof;
	}
    
    
    public Kitchen getKitchen() {
  		return kitchen;
  	}


  	public void setKitchen(Kitchen kitchen) {
  		this.kitchen = kitchen;
  	}


	public void setRoof(Roof roof) {
		this.roof = roof;
	}


	public Windows getWindows() {
		return windows;
	}


	public void setWindows(Windows windows) {
		this.windows = windows;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
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


	public SystemS getSystemS() {
		return systemS;
	}


	public void setSystemS(SystemS systemS) {
		this.systemS = systemS;
	}


	public SystemG getSystemG() {
		return systemG;
	}


	public void setSystemG(SystemG systemG) {
		this.systemG = systemG;
	}

	
	
	public Cabinet getCabinet() {
		return cabinet;
	}


	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}
	
	public String getIdAgency() {
		return IdAgency;
	}


	public void setIdAgency(String idAgency) {
		IdAgency = idAgency;
	}
	
	@Override
	public String toString(){
		return "caseID="+IdCase+", Price1="+Price1+", Price2="+Price2+", DateIn="+DateIn;
	}
	
}
