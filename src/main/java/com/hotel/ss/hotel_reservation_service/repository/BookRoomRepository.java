package com.hotel.ss.hotel_reservation_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.ss.hotel_reservation_service.entity.BookRoom;

public interface BookRoomRepository extends JpaRepository<BookRoom, Long> {
	List<BookRoom> findAllByEmail(String email);
	Optional<BookRoom> findByBookingId(Long bookigId);
}
