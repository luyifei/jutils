package com.os.jutils;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilsTest {
	@Test
	public void strToOtherTest() {
		Assert.assertEquals(1, MathUtils.toInt(" ", 1));
		Assert.assertEquals(1234, MathUtils.toInt("1234", 1));

		Assert.assertEquals(123, MathUtils.toLong("123", 0));
		Assert.assertEquals(123, MathUtils.toLong(" ", 123));

		System.out.println(MathUtils.toFloat("123", 123));
		System.out.println(MathUtils.toFloat(" ", 1234));

		System.out.println(MathUtils.toDouble(" 1", 2221));
		System.out.println(MathUtils.toBigDecimal("1234"));
	}

	@Test
	public void toBigDecimalTest() {
		System.out.println(MathUtils.toBigDecimal("1"));
		Assert.assertEquals(BigDecimal.valueOf(1), MathUtils.toBigDecimal("1"));
	}

	@Test
	public void maxTest() {
		float[] farr = new float[10];
		double[] darr = new double[10];

		for (int i = 0; i < 10; i++) {
			farr[i] = (float) Math.random();
			darr[i] = Math.random();
			System.out.println("f:" + farr[i]);
			System.out.println("d:" + darr[i]);
		}
		System.out.println(MathUtils.max(farr));
		System.out.println(MathUtils.min(farr));

		System.out.println(MathUtils.max(darr));
		System.out.println(MathUtils.min(darr));

	}

	@Test
	public void randomNumberTest() {
		float[] farr = new float[3];
		for (int i = 0; i < 3; i++) {
			farr[i] = i;
		}
		System.out.println(MathUtils.randomNumber(0, 3,new Integer[]{1,1}));
	}

}
