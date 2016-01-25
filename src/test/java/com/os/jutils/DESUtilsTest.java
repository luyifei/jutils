package com.os.jutils;

import org.junit.Test;

public class DESUtilsTest {

	@Test
	public void encryptTest(){
		try {
			System.out.println(DESUtils.encrypt("123", "11111111"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void decryptTest(){
		try {
			System.out.println(DESUtils.decrypt("lQlX0Xg0HYY=", "1111111111111111"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
