package com.os.jutils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * 日期格式 YYYY-MM-DD HH:mm:ss
	 */
	public static final String YYYYMMDD_HHMMSS = "YYYY-MM-DD HH:mm:ss";
	/**
	 * 日期格式 YYYY-MM-DD
	 */
	public static final String YYYYMMDD = "YYYY-MM-DD";
	/**
	 * 日期格式 YYYY年MM月dd日 HH时mm分ss秒
	 */
	public static final String YYYYMMDD_HHMMSS_CHINESE = "YYYY年MM月dd日 HH时mm分ss秒";
	/**
	 * 日期格式 YYYY年MM月dd日
	 */
	public static final String YYYYMMDD_CHINESE = "YYYY年MM月dd日";

	/**
	 * 构造方法私有化
	 */
	private DateUtils() {
		throw new Error("禁止实例化！");
	}

	/**
	 * 指定格式格式化时间
	 * 
	 * @param date
	 *            格式化时间
	 * @param formatString
	 *            格式化格式
	 * @return 格式化后的日期字符串
	 */
	public static String timeFormat(Date date, String formatString) {
		SimpleDateFormat sdf = getSimpleDateFormat(formatString);
		return sdf.format(date);
	}

	/**
	 * 指定格式格式化时间
	 * 
	 * @param timeStamp
	 *            格式化时间
	 * @param formatString
	 *            格式化格式
	 * @return 格式化后的日期字符串
	 */
	public static String timeFormat(Timestamp timeStamp, String formatString) {
		SimpleDateFormat sdf = getSimpleDateFormat(formatString);
		return sdf.format(timeStamp);
	}

	/**
	 * 指定"YYYY-MM-DD HH:mm:ss"格式，格式化日期
	 * 
	 * @param date
	 *            日期参数
	 * @return "YYYY-MM-DD HH:mm:ss"
	 */
	public static String getYYYYMMDD_HHMMSS(Date date) {
		return timeFormat(date, YYYYMMDD_HHMMSS);
	}

	/**
	 * 指定"YYYY-MM-DD HH:mm:ss"格式，格式化日期
	 * 
	 * @param timeStamp
	 *            日期参数
	 * @return "YYYY-MM-DD HH:mm:ss"
	 */
	public static String getYYYYMMDD_HHMMSS(Timestamp timeStamp) {
		return timeFormat(timeStamp, YYYYMMDD_HHMMSS);
	}

	/**
	 * 指定"YYYY-MM-DD"格式，格式化日期
	 * 
	 * @param date
	 *            日期参数
	 * @return "YYYY-MM-DD"
	 */
	public static String getYYYYMMDD(Date date) {
		return timeFormat(date, YYYYMMDD);
	}

	/**
	 * 指定"YYYY-MM-DD"格式，格式化日期
	 * 
	 * @param timeStamp
	 *            日期参数
	 * @return "YYYY-MM-DD"
	 */
	public static String getYYYYMMDD(Timestamp timeStamp) {
		return timeFormat(timeStamp, YYYYMMDD);
	}

	/**
	 * Date类型日期转化为Timestamp类型日期
	 * 
	 * @param date
	 *            日期参数
	 * @return Timestamp
	 */
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * TimeStamp类型日期转化为Date类型日期
	 * 
	 * @param timeStamp
	 *            日期参数
	 * @return Date
	 */
	public static Date timestampToDate(Timestamp timeStamp) {
		return new Date(timeStamp.getTime());
	}

	/**
	 * 
	 * @param timeString
	 *            时间字符串
	 * @param formatString
	 *            时间字符串解析格式
	 * @return date
	 * @throws ParseException
	 */
	public static Date stringToDate(String timeString, String formatString) throws ParseException {
		SimpleDateFormat sdf = getSimpleDateFormat(formatString);
		return sdf.parse(timeString);
	}

	/**
	 * 
	 * @param timeString
	 *            时间字符串
	 * @param formatString
	 *            时间字符串解析格式
	 * @return timestamp
	 * @throws ParseException
	 */
	public static Timestamp stringToTimestamp(String timeString, String formatString) throws ParseException {
		return dateToTimestamp(stringToDate(timeString, formatString));
	}

	private static SimpleDateFormat getSimpleDateFormat(String formatString) {
		return new SimpleDateFormat(formatString);
	}
}
