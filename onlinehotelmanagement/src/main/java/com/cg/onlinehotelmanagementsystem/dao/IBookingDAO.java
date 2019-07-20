package com.cg.onlinehotelmanagementsystem.dao;



import com.cg.onlinehotelmanagementsystem.bean.BookingDetailsBean;
import com.cg.onlinehotelmanagementsystem.bean.CustomerDataBean;
import com.cg.onlinehotelmanagementsystem.bean.HotelDetailsBean;
import com.cg.onlinehotelmanagementsystem.bean.RoomDetailsBean;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;

public interface IBookingDAO {
	int checkBooking(RoomDetailsBean roomDetailsDTO,BookingDetailsBean bookingDetailsDTO) throws ExceptionHandler;
	int setBookingDetails(BookingDetailsBean bookingDetailsDTO, RoomDetailsBean roomDetailsDTO,HotelDetailsBean hotelDetailsDTO,CustomerDataBean customerDataDTO) throws ExceptionHandler;
	void searchIdForCancel(int bookingId)throws ExceptionHandler;
	Number getNumberOfBooking(BookingDetailsBean bookingDetailsBean);

}
