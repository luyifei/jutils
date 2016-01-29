package com.os.jutils;

import org.junit.Test;

import com.os.u2redis.App;


public class SerializationUtilsTest {
	@Test
	public void writeObjectTest(){
		SerializationUtils.writeObject(new App());
	}
	
	
	@Test
	public void readObjectTest(){
		App a = SerializationUtils.readObject(App.class);
		System.out.println(a.age);
	}
}
