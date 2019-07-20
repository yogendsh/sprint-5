//package com.cg.onlinehotelmanagementsystem.utility;
//
//	public class JPAQuery {
//	
//	public static final String GET_ROOM_DETAILS = "SELECT bookObject from BookingDetailsDTO bookObject where bookObject.checkinbook BETWEEN TO_DATE(:checkinbook,'dd-MM-yyyy') AND TO_DATE(:checkoutbook,'dd-MM-yyyy') OR bookObject.checkoutbook BETWEEN TO_DATE(:checkinbook,'dd-MM-yyyy') AND TO_DATE(:checkoutbook,'dd-MM-yyyy')";
//
//	//public static final String SET_BOOK_DETAILS = "insert into BookingDetailsDTO bookObject(BOOKINGID,hoteldetails  ,ROOMID, CUSTOMERID, CHECKIN, CHECKOUT,AMOUNT ) values(book_seq.NEXTVAL, 123456, :roomid, 1, :checkin, :checkout,:amount)";
//	
//	public static final String CANCEL_BOOKING ="DELETE FROM BOOKINGDETAILS WHERE BOOKINGID=?";
//}
