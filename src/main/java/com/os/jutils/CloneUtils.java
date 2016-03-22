package com.os.jutils;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.io.output.ByteArrayOutputStream;

public class CloneUtils {

	/**
	 * 对一个对象进行深度克隆,需要实现序列化接口(Apache下的commons工具包中的SerializationUtils类也实现该功能)
	 *
	 * @param obj
	 *            需要克隆对象
	 * @return 克隆后对象
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		T cloneObj = null;
		try {
			// 读取对象字节数据
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			// 分配内存空间，写入原始对象，生产新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			cloneObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cloneObj;
	}
}
