package com.hotel.ss.hotel_reservation_service.vo;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoomBookingForm {

	private Long bookingId;
	@Size(min=3, max=30, message = "First name must be between 3 and 30 characters")
	private String firstName;
	private String lastName;
	@Valid
	private AddressVO address;
	@NotNull(message = "Mobile number must be provided")
	private Long mobNumber;
	@Email(regexp = ".+[@].+[\\.].+", message = "Valid email required")
	private String email;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Check in date must be provided")
	private Date checkIn;
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Check out date must be provided")
	private Date checkOut;
	private String roomPreference = "standard";
	@NotNull(message = "Please select number of guests")
	private Integer numOfAdults;
	private Integer children;
	
}
