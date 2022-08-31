package com.hotel.ss.hotel_reservation_service.vo;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RoomPricingVO {
	private Long bookingId;
	private String roomPref;
	private Integer adults;
	private Integer children;
	private Long numOfDays;
	private BigDecimal price;
	private String email;
}
