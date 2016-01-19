package com.os.jutils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
	@Test
	public void isAllUpperCaseTest() {
		boolean isAllUpperCase = StringUtils.isAllUpperCase("DFASF");
		Assert.assertEquals(true, isAllUpperCase);
	}

	@Test
	public void isAllLowerCaseTest() {
		boolean isAllLowerCase = StringUtils.isAllLowerCase("dsfsfds");
		Assert.assertEquals(true, isAllLowerCase);
	}
	
	@Test
	public void isUpperCaseTest() {
		boolean isUpperCase = StringUtils.isUpperCase("123C4  C");
		Assert.assertEquals(true, isUpperCase);
	}

	@Test
	public void isLowerCaseTest() {
		boolean isLowerCase = StringUtils.isLowerCase("12xzcxzc35");
		Assert.assertEquals(true, isLowerCase);
	}
}
