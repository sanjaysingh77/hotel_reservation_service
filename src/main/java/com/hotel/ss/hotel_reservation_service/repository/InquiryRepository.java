package com.hotel.ss.hotel_reservation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.ss.hotel_reservation_service.entity.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
