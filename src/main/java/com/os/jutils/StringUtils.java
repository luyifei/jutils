package com.os.jutils;

public class StringUtils {
	/**
	 * null转化为空字符串
	 * 
	 * @param str
	 * @return "" 或 str
	 */
	public String nullToBlank(String str) {
		if (str == null) {
			return "";
		}
		return str;
	}
	
	public static void main(String[] args) {
	}
	
}
