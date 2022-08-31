package com.hotel.ss.hotel_reservation_service.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@NoArgsConstructor
@Getter
@Setter
public class InquiryFormVO {

	
	private Long id;
	
	@Size(min=3, max=30, message = "Name must be between 3 and 30 characters")
	private String name;
	
	private String email;
	
	@NotNull(message = "Mobile number must be provided")
	private Long  mobNumber;
	
	@NotNull(message = "Please add some text")
	private String inquiryText;
}
