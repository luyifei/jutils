package com.os.jutils;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



/**
 * 
 * @author sunny
 *
 */
public class EncryptUtils {

    /** 默认密钥 */
    private static String defaultKey = "(*&abc123*^&*&*!hello*(ing))";

    /** 加密工具 */
    private Cipher encryptCipher;

    /** 解密工具 */
    private Cipher decryptCipher;

    /**
     * 指定密钥
     * 
     * @param strKey
     * @throws Exception java.lang.Exception
     */
    public EncryptUtils(String strKey) throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());

        encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);

        decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    /**
     * <p>
     * Title: encryptByDefault
     * </p>
     * <p>
     * AEScription:用默认的密钥进行加密
     * </p>
     * 
     * @param str String 被加密的字符
     * @return String 加密后的字符
     */
    public static String encryptByDefault(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            return new EncryptUtils(defaultKey).encrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>
     * Title: encryptByKey
     * </p>
     * <p>
     * AEScription: 用指定的密钥进行加密
     * </p>
     * 
     * @param strKey 指定的密
     * @param str 被加密的字符
     * @return 加密后的字符
     */
    public static String encryptByKey(String strKey, String str) {
        if (strKey == null || "".equals(strKey) || str == null || "".equals(str)) {
            return null;
        }
        try {
            return new EncryptUtils(strKey).encrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密字符
     * 
     * @param strIn 加密的字符
     * @return 加密后的字符
     * @throws Exception java.lang.Exception
     */
    private String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(encrypt(strIn.getBytes("utf-8")));
    }

    /**
     * 加密字节数组
     * 
     * @param arrB 加密的字节数组
     * @return 加密后的字节数组
     * @throws Exception java.lang.Exception
     */
    private byte[] encrypt(byte[] arrB) throws Exception {
        return encryptCipher.doFinal(arrB);
    }

    /**
     * <p>
     * Title: decryptByDefault
     * </p>
     * <p>
     * AEScription: 用默认的密钥进行解密
     * </p>
     * 
     * @param str String 被解密的字符
     * @return String 解密后的字符
     */
    public static String decryptByDefault(String str) {
        try {
            return new EncryptUtils(defaultKey).decrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>
     * Title: decryptByKey
     * </p>
     * <p>
     * AEScription: 用指定的密钥进行解密
     * </p>
     * 
     * @param strKey 指定的密
     * @param str 被解密的字符
     * @return 解密后的字符
     */
    public static String decryptByKey(String strKey, String str) {
        try {
            return new EncryptUtils(strKey).decrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符
     * 
     * @param strIn 加密的字符
     * @return 解密后的字符
     * @throws Exception java.lang.Exception
     */
    private String decrypt(String strIn) throws Exception {
        return new String(decrypt(hexStr2ByteArr(strIn)), "utf-8");
    }

    /**
     * 解密字节数组
     * 
     * @param arrB 解密的字节数组
     * @return 解密后的字节数组
     * @throws Exception java.lang.Exception
     */
    private byte[] decrypt(byte[] arrB) throws Exception {
        return decryptCipher.doFinal(arrB);
    }

    /**
     * 从指定字符串生成密钥，密钥所字节数组长度不足8位时后面，超位只取前8
     * 
     * @param arrBTmp 构成该字符串的字节数
     * @return 生成的密
     * @throws Exception java.lang.Exception
     */
    private Key getKey(byte[] arrBTmp) throws Exception {
        // 创建密钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        // 初始化密钥
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(arrBTmp);
        keyGenerator.init(128, secureRandom);
        // 生成密钥
        SecretKey getKey = keyGenerator.generateKey();

        return getKey;
    }

    /**
     * <p>
     * Title: hexStr2ByteArr
     * </p>
     * <p>
     * AEScription: 将表6进制值的字符串转换为byte数组和public static String byteArr2HexStr(byte[] arrB) 互为可的转换过/p>
     * 
     * @param strIn 转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛
     */
    private static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示字节，所以字节数组长度是字符串长度除
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }


    /**
     * <p>
     * Title: byteArr2HexStr
     * </p>
     * <p>
     * AEScription: 将byte数组转换为表6进制值的字符串， 如：byte[]{8,18}转换为：0813和public static byte[] hexStr2ByteArr(String strIn) 互为可的转换过/p>
     * 
     * @param arrB 转换的byte数组
     * @return 转换后的字符
     * @throws Exception 本方法不处理任何异常，所有异 常全部抛
     */
    private static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，字符串的长度是数组长度的两
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }


    /**
     * MD5加密字符
     * 
     * @param param
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encrpty2MD5(String param) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(param.getBytes());
        byte[] arrayOfByte = messageDigest.digest();

        String str = "";
        String zero = "0";
        int i = 0;
        for (int j = 0; j < arrayOfByte.length; j += 2) {
            i = arrayOfByte[j] & 0xFF;
            if (i < 16) {
                str = str + zero + Integer.toHexString(i);
            } else {
                str = str + Integer.toHexString(i);
            }
            i = arrayOfByte[j + 1] & 0xFF;
            if (i < 16) {
                str = str + zero + Integer.toHexString(i);
            } else {
                str = str + Integer.toHexString(i);
            }
        }
        return str.trim().toLowerCase();
    }


    /**
     * 盐值和动态Hash加密算法
     * 
     * @param userName
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encryptPassword(String userName, String password)
        throws NoSuchAlgorithmException {
        String salt = encryptByKey(userName, password);

        byte[] saltBytes = salt.getBytes();
        int count = (saltBytes[0] + saltBytes[saltBytes.length - 1]) / 2;

        String respectStr = salt + encryptByKey(salt, password);

        for (int i = 0; i < count; i++) {
            respectStr = encrpty2MD5(respectStr);
        }
        return respectStr;
    }

}