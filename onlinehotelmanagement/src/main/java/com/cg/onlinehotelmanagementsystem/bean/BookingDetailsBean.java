package com.cg.onlinehotelmanagementsystem.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="bookingdetails")

public class BookingDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq")
	@SequenceGenerator(name="book_seq", sequenceName="book_seq", allocationSize=1)
	@Column(name="booking_id")
	private int bookingid;
	
	
	@Column(name="checkin")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkinbook;
	
	@Column(name="checkout")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkoutbook;
	
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="roomid")
	private RoomDetailsBean roomDetailsDTO;
	
	@OneToOne
	@JoinColumn(name="hotelid")
	private HotelDetailsBean hotelDetailsDTO;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private CustomerDataBean userDataDTO;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public LocalDate getCheckinbook() {
		return checkinbook;
	}

	public void setCheckinbook(LocalDate checkinbook) {
		this.checkinbook = checkinbook;
	}

	public LocalDate getCheckoutbook() {
		return checkoutbook;
	}

	public void setCheckoutbook(LocalDate checkoutbook) {
		this.checkoutbook = checkoutbook;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public RoomDetailsBean getRoomDetailsDTO() {
		return roomDetailsDTO;
	}

	public void setRoomDetailsDTO(RoomDetailsBean roomDetailsDTO) {
		this.roomDetailsDTO = roomDetailsDTO;
	}

	public HotelDetailsBean getHotelDetailsDTO() {
		return hotelDetailsDTO;
	}

	public void setHotelDetailsDTO(HotelDetailsBean hotelDetailsDTO) {
		this.hotelDetailsDTO = hotelDetailsDTO;
	}

	public CustomerDataBean getUserDataDTO() {
		return userDataDTO;
	}

	public void setUserDataDTO(CustomerDataBean userDataDTO) {
		this.userDataDTO = userDataDTO;
	}
	
	
	

	
}
