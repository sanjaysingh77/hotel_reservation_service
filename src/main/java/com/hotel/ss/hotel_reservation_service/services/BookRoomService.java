package com.hotel.ss.hotel_reservation_service.services;

import java.util.List;

import com.hotel.ss.hotel_reservation_service.entity.BookRoom;


public interface BookRoomService {

	BookRoom saveBookRoom(BookRoom bookRoom);

	List<BookRoom> getAll();

	BookRoom getBookRoomById(Long id);
	
	List<BookRoom> getBookRoomByEmail(String email);

	void deleteBookRoom(Long id);

}
