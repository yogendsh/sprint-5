package com.cg.onlinehotelmanagementsystem.service;


import com.cg.onlinehotelmanagementsystem.bean.BookingDetailsBean;
import com.cg.onlinehotelmanagementsystem.bean.RoomDetailsBean;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;

public interface IBookRoom {
	int bookRoom(RoomDetailsBean roomDetailsDTO,BookingDetailsBean bookingDetailsDTO)throws ExceptionHandler;

	void cancelBooking(int bookingId)throws ExceptionHandler;
	
	int findBooking(BookingDetailsBean bookingDetailsBean);

}
