package com.cg.onlinehotelmanagementsystem.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlinehotelmanagementsystem.bean.BookingDetailsBean;
import com.cg.onlinehotelmanagementsystem.bean.RoomDetailsBean;
import com.cg.onlinehotelmanagementsystem.exception.ExceptionHandler;
import com.cg.onlinehotelmanagementsystem.service.IBookRoom;
@RestController
public class HMSController {
	@Autowired
	IBookRoom bookRoomObject;
	
	public void setBookRoomObject(IBookRoom bookRoomObject) {
		this.bookRoomObject = bookRoomObject;
	}
	@PostMapping(path="/book",consumes="application/json",produces="application/json")
	public String bookRoom(@RequestBody RoomDetailsBean roomDTO) {
		BookingDetailsBean bookDTO=new BookingDetailsBean();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String checkIn="21-11-2019";
		String checkOut="23-11-2019";
		bookDTO.setCheckinbook(LocalDate.parse(checkIn, formatter));
		bookDTO.setCheckoutbook(LocalDate.parse(checkOut, formatter));
		
		int bookingId=0;
		try {
			
			bookingId=bookRoomObject.bookRoom(roomDTO, bookDTO);
			
		} catch (ExceptionHandler e) {
			
			System.out.println(e.getMessage());
		}
		
		return "Booking is confirmed and booking id is "+bookingId;
		
	}
	@DeleteMapping(value="/{id}") 
	@ResponseBody
	public String deleteRoom(@PathVariable("id") int bookingId) {
		try {
			bookRoomObject.cancelBooking(bookingId);
		} catch (ExceptionHandler e) {
			System.out.println(e.getMessage());
			
		}
		return "Booking is cancelled";

	}
	
	@PostMapping(path="/find",consumes="application/json",produces="application/json")
	public String findBookDate(@RequestBody BookingDetailsBean bookingDetailsBean) {
		return "Number of Booking is: "+bookRoomObject.findBooking(bookingDetailsBean);
		
	}
	



	}
