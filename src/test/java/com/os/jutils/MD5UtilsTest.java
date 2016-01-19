package com.os.jutils;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class MD5UtilsTest {
	@Test
	public void encryptStringtest(){
		System.out.println(MD5Utils.encrypt("张三"));
	}
	
	@Test
	public void encryptFiletest(){
		try {
			System.out.println(MD5Utils.encrypt(new File("E:\\安装介质\\新建文件夹\\444.zip")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
