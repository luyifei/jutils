package com.os.jutils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author finnick Zip压缩工具类，根据源文件、目标文件以及源目录和目标目录进行压缩文件
 *
 */
public class ZipUtils {
	// http://snowolf.iteye.com/blog/465433
	// 文件压缩后缀
	public static final String EXT = ".zip";
	private static final String BASE_DIR = "";

	// 符号"/"用来作为目录标识判断符
	private static final String PATH = File.separator;
	// 缓存数组大小
	private static final int BUFFER = 1024;

	/**
	 * 压缩
	 * 
	 * @param srcFile
	 *            源文件
	 * @throws Exception
	 */
	public static void compress(File srcFile) throws Exception {
		String name = srcFile.getName();
		String destPath = srcFile.getParent();
		compress(srcFile, destPath, name);
	}

	/**
	 * 压缩
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destPath
	 *            目标文件
	 * @throws Exception
	 */
	public static void compress(File srcFile, File destFile) throws Exception {

		// 对输出文件做CRC32校验
		CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(destFile), new CRC32());

		ZipOutputStream zos = new ZipOutputStream(cos);

		compress(srcFile, zos, BASE_DIR);

		zos.flush();
		zos.close();
	}

	/**
	 * 压缩文件
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destPath
	 *            目标文件路径
	 * @param fileName
	 *            目标文件名
	 * @throws Exception
	 */
	public static void compress(File srcFile, String destPath, String fileName) throws Exception {
		if (!destPath.endsWith(File.separator)) {
			destPath = destPath + File.separator;
		}
		String destFilePath = destPath + fileName + EXT;
		compress(srcFile, new File(destFilePath));
	}

	/**
	 * 压缩
	 * 
	 * @param srcPath
	 *            源文件路径
	 * @throws Exception
	 */
	public static void compress(String srcPath) throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile);
	}

	/**
	 * 文件压缩
	 * 
	 * @param srcPath
	 *            源文件路径
	 * @param destPath
	 *            目标文件路径
	 * @param fileName
	 *            目标文件名
	 * @throws Exception
	 */
	public static void compress(String srcPath, String destPath, String fileName) throws Exception {
		File srcFile = new File(srcPath);
		compress(srcFile, destPath, fileName);
	}

	private static void compress(File srcFile, ZipOutputStream zos, String basePath) throws Exception {
		if (srcFile.isDirectory()) {
			compressDir(srcFile, zos, basePath);
		} else {
			compressFile(srcFile, zos, basePath);
		}
	}

	/**
	 * 压缩目录
	 * 
	 * @param dir
	 * @param zos
	 * @param basePath
	 * @throws Exception
	 */
	private static void compressDir(File dir, ZipOutputStream zos, String basePath) throws Exception {

		File[] files = dir.listFiles();

		// 构建空目录
		if (files.length < 1) {
			ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);

			zos.putNextEntry(entry);
			zos.closeEntry();
		}

		for (File file : files) {

			// 递归压缩
			compress(file, zos, basePath + dir.getName() + PATH);

		}
	}

	/**
	 * 文件压缩
	 * 
	 * @param file
	 *            待压缩文件
	 * @param zos
	 *            ZipOutputStream
	 * @param dir
	 *            压缩文件中的当前路径
	 * @throws Exception
	 */
	private static void compressFile(File file, ZipOutputStream zos, String dir) throws Exception {

		/**
		 * 压缩包内文件名定义
		 * 
		 * <pre>
		 * 如果有多级目录，那么这里就需要给出包含目录的文件名 
		 * 如果用WinRAR打开压缩包，中文名将显示为乱码
		 * </pre>
		 */
		ZipEntry entry = new ZipEntry(dir + file.getName());

		zos.putNextEntry(entry);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

		int count;
		byte data[] = new byte[BUFFER];
		while ((count = bis.read(data, 0, BUFFER)) != -1) {
			zos.write(data, 0, count);
		}
		bis.close();

		zos.closeEntry();
	}
}
