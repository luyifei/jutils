package com.os.jutils;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {
	@Test
	public void randomOneTest() {
		String[] sarr = new String[2];
		for (int i = 0; i < 2; i++) {
			sarr[i] = "张" + i;
		}
		System.out.println(ArrayUtils.randomOne(sarr));
	}

	@Test
	public void isEmptyTest() {
		Assert.assertEquals(false, ArrayUtils.isEmpty(new Integer[] { 1, 2, 3 }));
		Assert.assertEquals(true, ArrayUtils.isEmpty(new Integer[] {}));
		Assert.assertEquals(true, ArrayUtils.isEmpty(null));
	}

	@Test
	public void containTest() {
		Assert.assertEquals(true, ArrayUtils.contain(new String[] { "张", "王", "李四" }, "王"));
		Assert.assertEquals(false, ArrayUtils.contain(new String[] { "张", "王", "李四" }, "王1"));
		Assert.assertEquals(false, ArrayUtils.contain(null, "王1"));
	}
}
