package com.os.jutils;

import java.math.BigDecimal;

public class ArithUtils {
	private ArithUtils(){
	}
	/**
	 * 对double数据类型进行加法运算
	 * @param args 相加的数据
	 * @return
	 */
	public static double plus(Double... args){
		BigDecimal bigDecimal = BigDecimal.ZERO;
		for (int i = 0; i < args.length; i++) {
			BigDecimal param = new BigDecimal(args[i].toString());
			bigDecimal = bigDecimal.add(param);
		}
		return bigDecimal.doubleValue();
	}
	/**
	 * 对double数据类型进行减法运算
	 * @param minuend 被减数
	 * @param meiosis 减数
	 * @return
	 */
	public static double minus(Double minuend,Double... meiosis){
		BigDecimal bigDecimal = new BigDecimal(minuend.toString());
		for (int i = 0; i < meiosis.length; i++) {
			BigDecimal param = new BigDecimal(meiosis[i].toString());
			bigDecimal = bigDecimal.subtract(param);
		}
		return bigDecimal.doubleValue();
	}
	
	/**
	 * 对double数据类型进行乘法运算
	 * @param faciend
	 * @param multipliers
	 * @return
	 */
	public static double multiply(Double faciend,Double... multipliers){
		BigDecimal bigDecimal = new BigDecimal(faciend.toString());
		for (int i = 0; i < multipliers.length; i++) {
			BigDecimal multiplicand = new BigDecimal(multipliers[i].toString());
			bigDecimal = bigDecimal.multiply(multiplicand);
		}
		return bigDecimal.doubleValue();
	}
	
	/**
	 * 都double数据类型进行除法运算
	 * @param dividend
	 * @param divisors
	 * @return
	 */
	public static double division(Double dividend,Double... divisors){
		BigDecimal bigDecimal = new BigDecimal(dividend.toString());
		for (int i = 0; i < divisors.length; i++) {
			BigDecimal divisor = new BigDecimal(divisors[i].toString());
			bigDecimal = bigDecimal.divide(divisor);
		}
		return bigDecimal.doubleValue();
	}
}
