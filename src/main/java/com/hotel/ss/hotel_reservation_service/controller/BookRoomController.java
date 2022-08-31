package com.hotel.ss.hotel_reservation_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.ss.hotel_reservation_service.entity.BookRoom;
import com.hotel.ss.hotel_reservation_service.mapper.BookRoomMapper;
import com.hotel.ss.hotel_reservation_service.services.BookRoomService;
import com.hotel.ss.hotel_reservation_service.vo.RoomBookingForm;
import com.hotel.ss.hotel_reservation_service.vo.RoomBookingList;

@RestController
@RequestMapping("api/book-room")
public class BookRoomController {

	@Autowired
	private BookRoomService bookRoomService;
	
	@GetMapping("/")
	public ResponseEntity<RoomBookingList> getAllBookings(){
		List<BookRoom> bookings = bookRoomService.getAll();
		if(bookings == null || bookings.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().body(RoomBookingList.builder().bookings(BookRoomMapper.entityListToVoList(bookings)).build());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoomBookingForm> getBookinById(@PathVariable("id") Long bookingId){
		BookRoom bookRoom = bookRoomService.getBookRoomById(bookingId);
		
		if(bookRoom == null) { 
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(BookRoomMapper.entityToVo(bookRoom));
	}
	
	@GetMapping("/email")
	public ResponseEntity<RoomBookingList> getBookinById(@RequestParam("email") String email){
		List<BookRoom> bookRoomList = bookRoomService.getBookRoomByEmail(email);
		
		if(bookRoomList == null || bookRoomList.size()==0) { 
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(RoomBookingList.builder().bookings(BookRoomMapper.entityListToVoList(bookRoomList)).build());
	}
	
	@PostMapping("/")
	public ResponseEntity<RoomBookingForm> createBooking(@Valid @RequestBody RoomBookingForm roomBookingForm) {
		BookRoom savedBooking = bookRoomService.saveBookRoom(BookRoomMapper.voToEntity(roomBookingForm));
		return ResponseEntity.ok().body(BookRoomMapper.entityToVo(savedBooking));
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") Long bookingId) {
		bookRoomService.deleteBookRoom(bookingId);
		return ResponseEntity.ok().build();
	}
	
}
