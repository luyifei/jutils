package com.os.jutils;

public class StringUtils {
	/**
	 * null转化为空字符串
	 * 
	 * @param str
	 * @return "" 或 str
	 */
	public static String nullToBlank(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}

	/**
	 * 判断字符串是否为null或空字符串
	 * 
	 * @param str
	 *            校验字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else {
			return "".equals(str.trim()) ? true : false;
		}
	}

	/**
	 * 判断字符串每个字符都是小写
	 * 
	 * @param str
	 *            校验字符串
	 * @return boolean
	 */
	public static boolean isAllLowerCase(String str) {
		if (isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLowerCase(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串每个字符都是大写字母
	 * 
	 * @param str
	 *            校验字符串
	 * @return boolean
	 */
	public static boolean isAllUpperCase(String str) {
		if (isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isUpperCase(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串包含字母是否是小写字母
	 * 
	 * @param str
	 *            校验字符串
	 * @return boolean
	 */
	public static boolean isLowerCase(String str) {
		if (isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				if (!Character.isLowerCase(ch)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断字符串包含字母是否大写字母
	 * 
	 * @param str
	 *            校验字符串
	 * @return boolean
	 */
	public static boolean isUpperCase(String str) {
		if (isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				if (!Character.isUpperCase(ch)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 进行tostring操作，如果传入的是null，返回空字符串。
	 * 
	 * @param obj
	 *            源
	 * @return String
	 */
	public static String toString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 如果对象为null，指定字符串替换
	 * 
	 * @param obj
	 *            源
	 * @param replaceStr
	 *            替换null的字符串
	 * @return String
	 */
	public static String toString(Object obj, String replaceStr) {
		return obj == null ? replaceStr : obj.toString();
	}

}
