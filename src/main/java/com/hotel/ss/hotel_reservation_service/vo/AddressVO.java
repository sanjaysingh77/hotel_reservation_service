package com.hotel.ss.hotel_reservation_service.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class AddressVO {

	private Long addressId;
	@NotNull(message = "Address must be provided")
	private String address1;
	private String address2;
	@NotNull(message = "City must be provided")
	private String city;
	@NotNull(message = "State must be provided")
	private String state;
	private String zipCode;
	
}
