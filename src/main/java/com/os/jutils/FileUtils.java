package com.os.jutils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作工具类
 * 
 * @author finnick
 *
 */
public class FileUtils {
	/**
	 * 私有化构造函数
	 */
	private FileUtils() {
		throw new Error("禁止实例化！");
	}

	/**
	 * 删除指定文件(不包括文件夹)
	 * 
	 * @param path
	 *            文件所在路径
	 * @param filename
	 *            文件名称
	 * @return boolean
	 */
	public static boolean delFile(String path, String filename) {
		File file = new File(path + File.separator + filename);
		return delFile(file);
	}

	/**
	 * 删除指定文件(不包括文件夹)
	 * 
	 * @param file
	 *            文件
	 * @return boolean
	 */
	public static boolean delFile(File file) {
		if (file.exists() && file.isFile()) {
			return file.delete();
		}
		return false;
	}

	/**
	 * 删除指定目录以及目录下面所有的文件
	 * 
	 * @param path
	 *            指定目录路径
	 */
	public static void delDir(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				file.delete();
			} else {
				for (int i = 0; i < files.length; i++) {
					File temp = files[i];
					delDir(temp.getPath());
				}
				file.delete();
			}
		} else if (file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 文件复制，需要保证srcFile和destFile文件类型一直，同为文件或者文件夹
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @param isOverWrite
	 *            是否覆盖
	 * @throws IOException
	 */
	public static void copy(File srcFile, File destFile, boolean isOverWrite) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException(srcFile.getPath() + "源目录不存在！");
		}
		if (srcFile.isFile()) {
			copySimpleFile(srcFile, destFile, isOverWrite);
		} else {
			if (!destFile.exists()) {
				destFile.mkdirs();
			}
			for (File child : srcFile.listFiles()) {
				copy(child, new File(destFile.getPath() + File.separator + child.getName()), isOverWrite);
			}
		}
	}

	/**
	 * 复制单文件
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @param isOverWrite
	 *            是否覆盖
	 * @throws IOException
	 */
	private static void copySimpleFile(File srcFile, File destFile, boolean isOverWrite) throws IOException {
		// 目标文件已存在
		if (destFile.exists()) {
			if (isOverWrite) {
				if (!destFile.delete()) {
					throw new RuntimeException(destFile.getPath() + "无法覆盖！");
				}
			} else {
				// 不允许覆盖
				return;
			}
		} else {
			File parentFile = destFile.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
		}
		InputStream is = new FileInputStream(srcFile);
		OutputStream os = new FileOutputStream(destFile);
		byte[] buffer = new byte[1024];
		int read = 0;
		while ((read = is.read(buffer)) != -1) {
			os.write(buffer, 0, read);
		}
		is.close();
		os.close();
	}

	/**
	 * 从文件路径中抽取文件名, 例如： "mypath/myfile.txt" -> "myfile.txt"。
	 * 
	 * @param path
	 *            文件路径
	 * @return
	 */
	public static String getFileName(String path) {
		if (path == null) {
			return null;
		}
		File file = new File(path);
		return file.getName();
	}

	/**
	 * 把文件字节保存成文件
	 * 
	 * @param bytes
	 *            文件字节
	 * @param file
	 *            目标文件
	 * @throws IOException
	 */
	public static void save(byte[] bytes, File file) throws IOException {
		if (bytes == null) {
			throw new IllegalArgumentException("文件字节不能为空");
		}
		InputStream is = new ByteArrayInputStream(bytes);
		save(is, file);
	}

	/**
	 * 把文件流保存成文件
	 * 
	 * @param is
	 *            文件流
	 * @param file
	 *            目标文件
	 * @throws IOException
	 */
	public static void save(InputStream is, File file) throws IOException {
		if (is == null) {
			throw new IllegalArgumentException("文件流不能为空");
		}
		if (file == null) {
			throw new IllegalArgumentException("保存文件不能为空");
		}
		// 输出流
		OutputStream os = null;
		// 文件夹不存在就创建。
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[1024];
		while ((bytesRead = is.read(buffer, 0, 1024)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		is.close();
	}
}
