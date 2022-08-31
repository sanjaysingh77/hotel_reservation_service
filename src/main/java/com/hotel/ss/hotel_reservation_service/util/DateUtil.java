package com.hotel.ss.hotel_reservation_service.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtil {

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Long getNumberOfDays(Date start, Date end) {
		return ChronoUnit.DAYS.between(convertToLocalDate(start), convertToLocalDate(end));
	}
}
