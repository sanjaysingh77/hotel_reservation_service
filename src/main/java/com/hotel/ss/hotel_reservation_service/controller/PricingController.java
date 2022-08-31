package com.hotel.ss.hotel_reservation_service.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.ss.hotel_reservation_service.entity.BookRoom;
import com.hotel.ss.hotel_reservation_service.mapper.BookRoomMapper;
import com.hotel.ss.hotel_reservation_service.services.BookRoomService;
import com.hotel.ss.hotel_reservation_service.services.RoomPricingService;
import com.hotel.ss.hotel_reservation_service.vo.RoomPricingVO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/pricing")
@CrossOrigin
public class PricingController {

	private final RoomPricingService pricingService;
	private final BookRoomService bookRoomService;
	
	@GetMapping(value = "/room-pricing/{id}")
	public ResponseEntity<RoomPricingVO> getRoomDetail(@PathVariable("id") Long bookingId) {
		BookRoom bookRoom = bookRoomService.getBookRoomById(bookingId);
		if(bookRoom!=null) {
			RoomPricingVO roomPricing = BookRoomMapper.pricingVoFromEntity(bookRoom);
			BigDecimal roomPrice = pricingService.calculateRoomPrice(roomPricing);
			roomPricing.setPrice(roomPrice);
			return ResponseEntity.ok(roomPricing);
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value = "/confirm-booking")
	public ResponseEntity<Void> getRoomPricing(@RequestBody RoomPricingVO roomPricing) {
		BookRoom bookRoom = bookRoomService.getBookRoomById(roomPricing.getBookingId());
		if(bookRoom!=null) {
			bookRoom.setPrice(roomPricing.getPrice());
			bookRoomService.saveBookRoom(bookRoom);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.internalServerError().build();
	}
	
}
