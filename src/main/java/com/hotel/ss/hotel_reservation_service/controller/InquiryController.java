package com.hotel.ss.hotel_reservation_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.ss.hotel_reservation_service.entity.Inquiry;
import com.hotel.ss.hotel_reservation_service.mapper.InquiryMapper;
import com.hotel.ss.hotel_reservation_service.services.InquiryService;
import com.hotel.ss.hotel_reservation_service.vo.InquiryFormVO;
import com.hotel.ss.hotel_reservation_service.vo.InquiryList;

@RestController
@RequestMapping("api/inquiry")
public class InquiryController {

	@Autowired
	private InquiryService inquiryService;
	
	@GetMapping("/")
	public ResponseEntity<InquiryList> getAllInquiries(){
		List<Inquiry> inquiries = inquiryService.getAllInquiries();
		if(inquiries == null || inquiries.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().body(InquiryList.builder().inquiries(InquiryMapper.entityListToVoList(inquiries)).build());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InquiryFormVO> getInquiryById(@PathVariable("id") Long inquiryId){
		Inquiry inquiry = inquiryService.getInquiryById(inquiryId);
		
		if(inquiry == null) { 
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(InquiryMapper.entityToVo(inquiry));
	}
	
	@PostMapping("/")
	public ResponseEntity<InquiryFormVO> createInquiry(@Valid @RequestBody InquiryFormVO inquiryForm) {
		Inquiry savedInquiry = inquiryService.saveInquiry(InquiryMapper.voToEntity(inquiryForm));
		return ResponseEntity.ok().body(InquiryMapper.entityToVo(savedInquiry));
	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<HttpStatus> deleteInquiry(@PathVariable("id") Long inquiryId) {
		inquiryService.deleteInquiry(inquiryId);
		return ResponseEntity.ok().build();
	}
	
}
