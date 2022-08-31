package com.hotel.ss.hotel_reservation_service.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.hotel.ss.hotel_reservation_service.vo.RoomPricingVO;

@Service
public class RoomPricingServiceImpl implements RoomPricingService {

	@Override
	public BigDecimal calculateRoomPrice(RoomPricingVO roomPricing) {
		
		Integer numOfRooms = 1;
		if(roomPricing.getAdults()>2) {
			numOfRooms =(int) Math.ceil((double)roomPricing.getAdults() / 2.0);
		}
		BigDecimal totalPrice = null;
		switch (roomPricing.getRoomPref()) {
		case "standard":
			totalPrice = BigDecimal.valueOf(1000 * roomPricing.getNumOfDays() * numOfRooms);
			break;
		case "deluxe":
			totalPrice = BigDecimal.valueOf(2000 * roomPricing.getNumOfDays() * numOfRooms);
			break;
		case "suite":
			totalPrice = BigDecimal.valueOf(5000 * roomPricing.getNumOfDays() * numOfRooms);
			break;
		}
		return totalPrice;
	}

}
