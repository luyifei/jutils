package com.os.jutils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String YYYYMMDD_hhmmss = "YYYY-MM-DD hh:mm:ss";

	public static String dateFormat(Date date, String formatString) {
		SimpleDateFormat sdf = getSimpleDateFormat(formatString);
		return sdf.format(date);
	}

	private static SimpleDateFormat getSimpleDateFormat(String formatString) {
		return new SimpleDateFormat(formatString);
	}
}
