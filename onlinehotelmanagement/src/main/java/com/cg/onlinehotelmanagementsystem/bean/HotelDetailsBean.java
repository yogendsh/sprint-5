package com.cg.onlinehotelmanagementsystem.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="hoteldetails")
public class HotelDetailsBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="hotelid")
	private int hotelid;
	private String hotelname;
	private String hoteladdress;
	@Column(name="number_of_rooms")
	private int numberofrooms;
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public void setHoteladdress(String hoteladdress) {
		this.hoteladdress = hoteladdress;
	}

	public void setNumberofrooms(int numberofrooms) {
		this.numberofrooms = numberofrooms;
	}
	
	
	public int getHotelid() {
		return hotelid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public String getHoteladdress() {
		return hoteladdress;
	}
	public int getNumberofrooms() {
		return numberofrooms;
	}
	
	}
	
    
    
    
	


