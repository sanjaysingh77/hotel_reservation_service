package com.hotel.ss.hotel_reservation_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.ss.hotel_reservation_service.entity.BookRoom;
import com.hotel.ss.hotel_reservation_service.repository.BookRoomRepository;


@Service
public class BookRoomServiceImpl implements BookRoomService{

	@Autowired
	private BookRoomRepository bookRoomRepo;
	
	@Override
	@Transactional
	public BookRoom saveBookRoom(BookRoom bookRoom) {
		return bookRoomRepo.save(bookRoom);
	}

	@Override
	@Transactional
	public List<BookRoom> getAll() {
		return bookRoomRepo.findAll();
	}

	@Override
	@Transactional
	public BookRoom getBookRoomById(Long id) {
		return bookRoomRepo.findByBookingId(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteBookRoom(Long id) {
		bookRoomRepo.deleteById(id);
	}

	@Override
	@Transactional
	public List<BookRoom> getBookRoomByEmail(String email) {
		return bookRoomRepo.findAllByEmail(email);
	}

}
