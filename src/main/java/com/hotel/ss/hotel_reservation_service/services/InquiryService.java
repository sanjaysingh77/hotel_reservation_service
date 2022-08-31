package com.hotel.ss.hotel_reservation_service.services;

import java.util.List;

import com.hotel.ss.hotel_reservation_service.entity.Inquiry;


public interface InquiryService {

	Inquiry saveInquiry(Inquiry inquiry);

	List<Inquiry> getAllInquiries();

	Inquiry getInquiryById(Long id);

	void deleteInquiry(Long id);

}
