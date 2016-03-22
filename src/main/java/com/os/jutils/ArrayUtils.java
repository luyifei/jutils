package com.os.jutils;

public final class ArrayUtils {
	/**
	 * 让工具类不可实例化
	 */
	private ArrayUtils(){
		throw new Error("禁止实例化！");
	};
	/**
	 * 从数组中随机取一个对象返回
	 * 
	 * @param array
	 *            取值数组
	 * @return T
	 */
	public static <T> T randomOne(T[] array) {
		if (isEmpty(array)) {
			return null;
		}
		return array[MathUtils.randomNumber(0, array.length)];
	}

	/**
	 * 判断数组是否为空
	 * 
	 * @param array
	 *            校验数据
	 * @return boolean
	 */
	public static <T> boolean isEmpty(T[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断数组中是否包含指定元素
	 * 
	 * @param array
	 *            查询数组
	 * @param element
	 *            指定元素
	 * @return boolean
	 */
	public static <T> boolean contain(T[] array, T element) {
		if (isEmpty(array)) {
			return false;
		}
		for (T t : array) {
			if (t.equals(element)) {
				return true;
			}
		}
		return false;
	}
}
