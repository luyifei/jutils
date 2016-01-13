package com.os.jutils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void dateFormatTest() {
		System.out.println(DateUtils.timeFormat(new Date(), DateUtils.YYYYMMDD_HHMMSS_CHINESE));
	}

	@Test
	public void timestampFormatTest() {
		System.out.println(DateUtils.timeFormat(new Timestamp(System.currentTimeMillis()), DateUtils.YYYYMMDD_HHMMSS));
	}
	
	@Test
	public void getDateFixedTest(){
		System.out.println(DateUtils.getYYYYMMDD(new Date()));
		System.out.println(DateUtils.getYYYYMMDD_HHMMSS(new Date()));
	}
	
	@Test
	public void getTimestampFixedTest(){
		System.out.println(DateUtils.getYYYYMMDD(new Timestamp(System.currentTimeMillis())));
		System.out.println(DateUtils.getYYYYMMDD_HHMMSS(new Timestamp(System.currentTimeMillis())));
	}
	
	@Test
	public void dateToTimestampTest(){
		System.out.println(new Date());
		System.out.println(DateUtils.dateToTimestamp(new Date()));
	}
	
	@Test
	public void timestampToDateTest(){
		System.out.println(new Timestamp(System.currentTimeMillis()));
		System.out.println(DateUtils.timestampToDate(new Timestamp(System.currentTimeMillis())));
	}
	
	@Test
	public void stringToDateTest(){
		try {
			System.out.println(DateUtils.stringToDate("2016-01-13 14:09:27", DateUtils.YYYYMMDD_HHMMSS));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void stringToTimestampTest(){
		try {
			System.out.println(DateUtils.stringToTimestamp("2016-01-13 14:09:27", DateUtils.YYYYMMDD_HHMMSS));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
