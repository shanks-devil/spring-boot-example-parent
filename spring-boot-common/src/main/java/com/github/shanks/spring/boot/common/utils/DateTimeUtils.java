package com.github.shanks.spring.boot.common.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeUtils {

	private static final DateTimeFormatter DEFAULT_PATTERN = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	public static DateTime parse(String value) {
		return DateTime.parse(value, DEFAULT_PATTERN);
	}
	
	public static DateTime parse(String value, DateTimeFormatter formatter) {
		return DateTime.parse(value, formatter);
	}
	
	public static String stringify(DateTime dateTime) {
		return stringify(dateTime, DEFAULT_PATTERN);
	}
	
	public static String stringify(DateTime dateTime, DateTimeFormatter formatter) {
		return dateTime.toString(formatter);
	}

	public static String stringify(DateTime dateTime, String pattern) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
		return dateTime.toString(formatter);
	}
}
