package com.clinic.appointment.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class DateUtil {

	private static long millis;
	public static Date getTodayStart() {
		LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
		millis = startOfDay.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
		return new Date(millis);
	}
	public static Date getTodayEnd() {
		LocalDateTime endOfDate = LocalDateTime.now().toLocalDate().atTime(LocalTime.MAX);
		millis = endOfDate.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
		return new Date(millis);
	}
	public static Date getDayStart(Date date) {
		LocalDateTime startOfDay = LocalDateTime.of(date.toLocalDate(), LocalTime.MIDNIGHT);
		millis = startOfDay.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
		return new Date(millis);
	}
	public static Date getDayEnd(Date date) {
		LocalDateTime endOfDate = date.toLocalDate().atTime(LocalTime.MAX);
		millis = endOfDate.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
		return new Date(millis);
	}
}
