package com.hotel.ss.hotel_reservation_service.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "book_room")
@Data
public class BookRoom {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long bookingId;
	private String firstName;
	private String lastName;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="address_id")
	private Address address;
	private Long mobNumber;
	private String email;
	private Date checkIn;
	private Date checkOut;
	private String roomPreference = "standard";
	private Integer numOfAdults;
	private Integer children;
	private BigDecimal price;
	
}
