package com.os.jutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtils {

	public static void writeObject(FileOutputStream fos, Serializable s) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.close();
	}

	@SuppressWarnings("unchecked")
	public static <T> T readObject(FileInputStream fis, Class<T> entityClass)
			throws IOException, ClassNotFoundException {
		T obj = null;
		ObjectInput oi = new ObjectInputStream(fis);
		obj = (T) oi.readObject();
		oi.close();
		return obj;
	}
}
