package com.hotel.ss.hotel_reservation_service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.hotel.ss.hotel_reservation_service.entity.Inquiry;
import com.hotel.ss.hotel_reservation_service.vo.InquiryFormVO;

public class InquiryMapper {
	
	public static Inquiry voToEntity(InquiryFormVO vo) {
		Inquiry entity = new Inquiry();
		entity.setId(vo.getId());
		entity.setName(vo.getName());
		entity.setEmail(vo.getEmail());
		entity.setMobNumber(vo.getMobNumber());
		entity.setInquiryText(vo.getInquiryText());
		return entity;		
	}
	
	public static InquiryFormVO entityToVo(Inquiry entity) {
		InquiryFormVO vo = new InquiryFormVO();
		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setEmail(entity.getEmail());
		vo.setMobNumber(entity.getMobNumber());
		vo.setInquiryText(entity.getInquiryText());
		return vo;		
	}
	
	public static List<InquiryFormVO> entityListToVoList(List<Inquiry> entityList){
		return entityList.stream().map(entity -> entityToVo(entity)).collect(Collectors.toList());
	}
	
	public static List<Inquiry> voListToEntityList(List<InquiryFormVO> voList){
		return voList.stream().map(vo -> voToEntity(vo)).collect(Collectors.toList());
	}
	
}
