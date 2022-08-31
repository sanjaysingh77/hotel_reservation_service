package com.hotel.ss.hotel_reservation_service.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "address")
@Data
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
	private Long addressId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	
	@OneToOne(mappedBy = "address", cascade=CascadeType.ALL)
	private BookRoom bookRoom;
	
}
