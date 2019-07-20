package com.cg.onlinehotelmanagementsystem.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinehotelmanagementsystem.bean.BookingDetailsBean;
import com.cg.onlinehotelmanagementsystem.bean.CustomerDataBean;
import com.cg.onlinehotelmanagementsystem.bean.HotelDetailsBean;
import com.cg.onlinehotelmanagementsystem.bean.RoomDetailsBean;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;
import com.cg.onlinehotelmanagementsystem.utility.IExceptionClass;

@Repository
@Transactional
public class BookingDAO implements IBookingDAO {
	@PersistenceContext
	EntityManager entityManager;

	public int checkBooking(RoomDetailsBean roomDetailsDTO, BookingDetailsBean bookingDetailsDTO) throws ExceptionHandler {
		bookingDetailsDTO.setRoomDetailsDTO(roomDetailsDTO);
		TypedQuery<BookingDetailsBean> query = entityManager.createQuery(
				"SELECT bookObject from BookingDetailsBean bookObject,RoomDetailsBean roomObject,HotelDetailsBean hotelObject where hotelObject.hotelid=123456 and roomObject.roomId=:roomid and (bookObject.checkinbook BETWEEN :checkinbook AND :checkoutbook) OR (bookObject.checkoutbook BETWEEN :checkinbook AND :checkoutbook)",
				BookingDetailsBean.class);
		query.setParameter("roomid", bookingDetailsDTO.getRoomDetailsDTO().getRoomId());
		query.setParameter("checkinbook", LocalDate.parse(bookingDetailsDTO.getCheckinbook().toString()));

		query.setParameter("checkoutbook", LocalDate.parse(bookingDetailsDTO.getCheckoutbook().toString()));

		query.setParameter("checkinbook", LocalDate.parse(bookingDetailsDTO.getCheckinbook().toString()));

		query.setParameter("checkoutbook", LocalDate.parse(bookingDetailsDTO.getCheckoutbook().toString()));

		if (query.getResultList().size() == 0) {
			return 0;

		} else
			return 1;

	}

	public int setBookingDetails(BookingDetailsBean bookingDetailsDTO, RoomDetailsBean roomDetailsDTO,
			HotelDetailsBean hotelDetailsDTO, CustomerDataBean userDataDTO) {

		bookingDetailsDTO.setRoomDetailsDTO(roomDetailsDTO);
		bookingDetailsDTO.setHotelDetailsDTO(hotelDetailsDTO);
		bookingDetailsDTO.setUserDataDTO(userDataDTO);
		
		entityManager.persist(bookingDetailsDTO);
	

		return bookingDetailsDTO.getBookingid();
	}

	public void searchIdForCancel(int bookingId) throws ExceptionHandler {

		BookingDetailsBean bookingDetailsDTO = entityManager.find(BookingDetailsBean.class, bookingId);
		if (bookingDetailsDTO != null) {

			entityManager.remove(bookingDetailsDTO);

		} else
			throw new ExceptionHandler(IExceptionClass.CANCEL_BOOKING);

	}

	public Number getNumberOfBooking(BookingDetailsBean bookingDetailsBean) {
		Query query = entityManager.createQuery(
				"SELECT count(bookObject.bookingid) from BookingDetailsBean bookObject where (bookObject.checkinbook BETWEEN :checkinbook AND :checkoutbook) OR (bookObject.checkoutbook BETWEEN :checkinbook AND :checkoutbook)"
				);
		query.setParameter("checkinbook", LocalDate.parse(bookingDetailsBean.getCheckinbook().toString()));

		query.setParameter("checkoutbook", LocalDate.parse(bookingDetailsBean.getCheckoutbook().toString()));

		query.setParameter("checkinbook", LocalDate.parse(bookingDetailsBean.getCheckinbook().toString()));

		query.setParameter("checkoutbook", LocalDate.parse(bookingDetailsBean.getCheckoutbook().toString()));

		return (Number)(query.getSingleResult());
	}

}
