package com.os.jutils;

import org.junit.Test;
import static org.junit.Assert.*;

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
		assertEquals(false, ArrayUtils.isEmpty(new Integer[] { 1, 2, 3 }));
		assertEquals(true, ArrayUtils.isEmpty(new Integer[] {}));
		assertEquals(true, ArrayUtils.isEmpty(null));
	}

	@Test
	public void containTest() {
		assertEquals(true, ArrayUtils.contain(new String[] { "张", "王", "李四" }, "王"));
		assertEquals(false, ArrayUtils.contain(new String[] { "张", "王", "李四" }, "王1"));
		assertEquals(false, ArrayUtils.contain(null, "王1"));
	}
}
