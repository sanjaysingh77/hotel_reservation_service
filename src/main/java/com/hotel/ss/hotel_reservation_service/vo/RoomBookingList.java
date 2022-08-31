package com.hotel.ss.hotel_reservation_service.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RoomBookingList {
	private List<RoomBookingForm> bookings;
}
