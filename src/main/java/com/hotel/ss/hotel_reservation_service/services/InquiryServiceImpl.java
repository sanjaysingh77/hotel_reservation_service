package com.hotel.ss.hotel_reservation_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.ss.hotel_reservation_service.entity.Inquiry;
import com.hotel.ss.hotel_reservation_service.repository.InquiryRepository;

@Service
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	private InquiryRepository inquiryRepo;
	
	@Override
	@Transactional
	public Inquiry saveInquiry(Inquiry inquiry) {
		return inquiryRepo.save(inquiry);
	}

	@Override
	@Transactional
	public List<Inquiry> getAllInquiries() {
		return inquiryRepo.findAll();
	}

	@Override
	@Transactional
	public Inquiry getInquiryById(Long id) {
		return inquiryRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteInquiry(Long id) {
		inquiryRepo.deleteById(id);
	}

}
