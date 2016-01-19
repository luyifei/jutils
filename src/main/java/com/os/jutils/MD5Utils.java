package com.os.jutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	protected static MessageDigest md5 = null;

	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsaex) {
			System.err.println(MD5Utils.class.getName() + "初始化失败，MessageDigest不支持MD5Utils。");
			nsaex.printStackTrace();
		}
	}

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param str
	 *            源字符串
	 * @return 加密后字符串
	 */
	public static String encrypt(String str) {
		if (str == null) {
			throw new IllegalArgumentException("str不能为null");
		}
		return bytesToHex(md5.digest(str.getBytes()));
	}

	/**
	 * 获取文件的MD5值
	 * 
	 * @param file
	 *            源文件
	 * @return 源文件MD5值
	 * @throws IOException
	 */
	public static String encrypt(File file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException("file不能为null");
		}
		if (!file.exists()) {
			throw new IllegalArgumentException("file目录或文件不存在");
		}
		FileInputStream fis = new FileInputStream(file);
		try {
			FileChannel ch = fis.getChannel();
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			md5.update(byteBuffer);
		} catch (Exception e) {
			throw e;
		} finally {
			fis.close();
		}
		return bytesToHex(md5.digest());
	}

	/**
	 * 二进制转十六进制
	 * 
	 * @param bytes
	 * @return 转化后字符串
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];

			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString().toUpperCase();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(encrypt(new File("E:\\安装介质\\新建文件夹\\123.zip")));
	}
}
