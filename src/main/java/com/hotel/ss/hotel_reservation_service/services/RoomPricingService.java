package com.hotel.ss.hotel_reservation_service.services;

import java.math.BigDecimal;

import com.hotel.ss.hotel_reservation_service.vo.RoomPricingVO;

public interface RoomPricingService {
	
	BigDecimal calculateRoomPrice(RoomPricingVO roomPricing);
}
