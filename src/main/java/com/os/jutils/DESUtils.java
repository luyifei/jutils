package com.os.jutils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 还存在问题待解决. DES（Data Encryption
 * Standard）是发明最早的最广泛使用的分组对称加密算法。DES算法的入口参数有三个：Key、Data、Mode。
 * 其中Key为8个字节共64位，是DES算法的工作密钥；Data也为8个字节64位，是要被加密或被解密的数据；Mode为DES的工作方式，
 * 有两种：加密或解密
 * 
 * @author finnick
 */
public class DESUtils {
	private final static String DES = "DES";

	/**
	 * 私有化构造方法
	 */
	private DESUtils() {
		throw new Error("禁止实例化！");
	}

	/**
	 * 根据键值进行加密
	 * 
	 * @param data
	 *            加密数据
	 * @param key
	 *            加密键值
	 * @return 加密后的字符串
	 */
	public static String encrypt(String data, String key) throws Exception {
		if (data == null) {
			throw new IllegalArgumentException("data为null");
		}
		if (key == null) {
			throw new IllegalArgumentException("key为null");
		}
		// 获取加密后的byte数组
		byte[] encryptByte = encrypt(data.getBytes(), key.getBytes());
		// 对byte数组进行编码
		BASE64Encoder encoder = new BASE64Encoder();
		String str = encoder.encode(encryptByte);
		return str;
	}

	/**
	 * 根据键值进行解密
	 * 
	 * @param data
	 *            解密数据
	 * @param key
	 *            解密键值
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws Exception {
		if (data == null) {
			throw new IllegalArgumentException("data为null");
		}
		if (key == null) {
			throw new IllegalArgumentException("key为null");
		}
		// 对字符串进行解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodeByte = decoder.decodeBuffer(data);
		// 对解码字符串进行解密
		byte[] decryptByte = decrypt(decodeByte, key.getBytes());
		return new String(decryptByte);
	}

	/**
	 * 根据key值byte数组对data值数组进行加密
	 * 
	 * @param data
	 *            加密数据byte数组
	 * @param key
	 *            加密键值byte数组
	 * @return 加密后的byte数组
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * 根据key值byte数组对data值数组进行解密
	 * 
	 * @param data
	 *            解密数据byte数组
	 * @param key
	 *            解密键值byte数组
	 * @return 解密后的byte数组
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}
}
