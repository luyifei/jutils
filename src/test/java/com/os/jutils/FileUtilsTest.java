package com.os.jutils;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FileUtilsTest {
	@Test
	public void copyTest() {
		File srcFile = new File("E:\\test\\123.txt");
		File destFile = new File("E:\\a\\f\\ff\\123.txt");
		try {
			FileUtils.copy(srcFile, destFile, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getFileNameTest() {
		Assert.assertEquals("ff", FileUtils.getFileName("E:\\a\\f\\ff\\ff"));
	}

	@Test
	public void saveTest() {
		try {
			FileUtils.save("111111111".getBytes(), new File("E:\\test\\0.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
