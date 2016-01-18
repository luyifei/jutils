package com.os.jutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PropertiesUtils {

	/**
	 * 指定properties文件获取对应key键的value值
	 * 
	 * @param resource
	 *            classpath路径下的文件地址
	 * @param key
	 *            对应key值
	 * @return key对应的value值
	 * @throws IOException
	 */
	public static String getValue(String resource, String key) throws IOException {
		Properties properties = loadProperties(resource);
		Enumeration<?> enumer = properties.propertyNames();
		while (enumer.hasMoreElements()) {
			String value = properties.getProperty(key);
			return value;
		}
		return null;
	}

	/**
	 * 获取properties文件中所有的键值对
	 * 
	 * @param resource
	 *            classpath路径下的文件地址
	 * @return properties文件键值对
	 * @throws IOException
	 */
	public static Map<String, String> getProperties(String resource) throws IOException {
		Properties properties = loadProperties(resource);
		Map<String, String> enums = new HashMap<String, String>();
		Enumeration<?> enumer = properties.propertyNames();
		while (enumer.hasMoreElements()) {
			String key = (String) enumer.nextElement();
			String value = properties.getProperty(key);
			enums.put(key, value);
		}
		return enums;
	}

	/**
	 * 写入键值对到properties文件中，功能未能实现
	 * @param resource
	 * @param key
	 * @param value
	 * @throws IOException
	 */
	public static void writeProperties(String resource, String key, String value) throws IOException {
		//TODO 貌似功能没有生效
		InputStream is = ClassLoader.getSystemResourceAsStream(resource);
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (NullPointerException e) {
			System.out.println("指定资源文件不存在");
			throw e;
		}
		URL url = ClassLoader.getSystemResource(resource);
		System.out.println(new File(url.getPath()).isFile());
		OutputStream out = new FileOutputStream(url.getPath());
		properties.setProperty(key, value);
		// 以适合使用 load 方法加载到 Properties 表中的格式，
		// 将此 Properties 表中的属性列表（键和元素对）写入输出流
		properties.store(out, "Update " + key + " name");
		out.flush();
		out.close();
		is.close();
	}
	
	/**
	 * 加载指定的文件
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	private static Properties loadProperties(String resource) throws IOException {
		InputStream is = ClassLoader.getSystemResourceAsStream(resource);
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (NullPointerException e) {
			System.out.println("指定资源文件不存在");
			throw e;
		}
		return properties;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(PropertiesUtils.getValue("test/person.properties", "name"));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
