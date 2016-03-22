package com.os.jutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtils {
	private static String FILE_NAME = "c:/obj.bin";

	public static void writeObject(FileOutputStream fos, Serializable s) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T readObject(FileInputStream fis, Class<T> entityClass) {
		// Class clazz
		T obj = null;
		try {
			ObjectInput oi = new ObjectInputStream(fis);
			obj = (T) oi.readObject();
			oi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
