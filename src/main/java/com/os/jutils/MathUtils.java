package com.os.jutils;

import java.math.BigDecimal;

public class MathUtils {
	/**
	 * 私有化构造方法
	 */
	private MathUtils() {
		throw new Error("禁止实例化！");
	}

	/**
	 * 将字符串转化为int，如果失败返回默认值。
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return int
	 */
	public static int toInt(String str, int defaultValue) {
		if (StringUtils.isEmpty(str)) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转化为long，如果失败返回默认值。
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return long
	 */
	public static long toLong(String str, long defaultValue) {
		if (StringUtils.isEmpty(str)) {
			return defaultValue;
		}
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转化为float，如果失败返回默认值。
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return float
	 */
	public static float toFloat(String str, float defaultValue) {
		if (StringUtils.isEmpty(str)) {
			return defaultValue;
		}
		try {
			return Float.parseFloat(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转化为double，如果失败返回默认值。
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return double
	 */
	public static double toDouble(String str, double defaultValue) {
		if (StringUtils.isEmpty(str)) {
			return defaultValue;
		}
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转化为BigDecimal，如果失败返回默认值。
	 * 
	 * @param str
	 *            字符串
	 * @return BigDecimal
	 */
	public static BigDecimal toBigDecimal(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		return new BigDecimal(str);
	}

	/**
	 * 获取float数组中最大值
	 * 
	 * @param array
	 *            float数组
	 * @return 最大值
	 */
	public static float max(float[] array) {
		if (array == null) {
			throw new IllegalArgumentException("参数不能为null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("参数数组不能为空");
		}
		float max = array[0];
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}
		return max;
	}

	/**
	 * 获取double数组中最大值
	 * 
	 * @param array
	 *            double数组
	 * @return 最大值
	 */
	public static double max(double[] array) {
		if (array == null) {
			throw new IllegalArgumentException("参数不能为null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("参数数组不能为空");
		}
		double max = array[0];
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}
		return max;
	}

	/**
	 * 获取float数组中最小值
	 * 
	 * @param array
	 *            float数组
	 * @return 最小值
	 */
	public static float min(float[] array) {
		if (array == null) {
			throw new IllegalArgumentException("参数不能为null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("参数数组不能为空");
		}
		float min = array[0];
		for (int i = 1; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}
		return min;
	}

	/**
	 * 获取double数组中最小值
	 * 
	 * @param array
	 *            double数组
	 * @return 最小值
	 */
	public static double min(double[] array) {
		if (array == null) {
			throw new IllegalArgumentException("参数不能为null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("参数数组不能为空");
		}
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}
		return min;
	}

	/**
	 * 生成一个在最大值和最小值之间的随机数。会出现最小值，但不会出现最大值。
	 * 
	 * @param minNum
	 *            最小值
	 * @param maxNum
	 *            最大值
	 * @return int
	 */
	public static int randomNumber(int minNum, int maxNum) {
		if (minNum >= maxNum) {
			throw new IllegalArgumentException("maxNum必须大于minNum!");
		}
		int subtract = maxNum - minNum;
		Double ranDouble = Math.floor(Math.random() * subtract);
		return ranDouble.intValue() + minNum;
	}

	/**
	 * 
	 * 生成一个在最大值和最小值之间的随机数。会出现最小值，但不会出现最大值。<br/>
	 * 但不随机excludes数组中指定的数字， 如果可随机的范围较小，可能会一直随机不到，或者随机的很慢。
	 * 
	 * @param minNum
	 *            最小值
	 * @param maxNum
	 *            最大值
	 * @param excludes
	 *            排除值数组
	 * @return int
	 */
	public static int randomNumber(int minNum, int maxNum, Integer[] excludes) {
		while (true) {
			int random = randomNumber(minNum, maxNum);
			if (!ArrayUtils.contain(excludes, random)) {
				return random;
			}
		}
	}

}
