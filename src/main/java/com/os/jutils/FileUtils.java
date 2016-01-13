package com.os.jutils;

import java.io.File;

public class FileUtils {

	/**
	 * 删除指定文件
	 * 
	 * @param path
	 *            文件所在路径
	 * @param filename
	 *            文件名称
	 */
	public static void delFile(String path, String filename) {
		File file = new File(path + File.separator + filename);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
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
}
