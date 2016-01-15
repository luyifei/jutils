package com.os.jutils;

import java.io.File;

import org.junit.Test;

public class ZipUtilsTest {

	/** 
	 *   
	 */
	@Test
	public void compressTest() throws Exception {
		// 指定源目录压缩
		// ZipUtils.compress("E:\\test");
		// 指定源目录，目标目录，目标文件名
		// ZipUtils.compress("E:\\test", "E:\\安装介质\\新建文件夹", "123");
		// 指定源文件压缩
		// ZipUtils.compress(new File("E:\\test"));
		// 指定源文件，目标文件
		// ZipUtils.compress(new File("E:\\test"), new File("E:\\安装介质\\新建文件夹\\444.zip"));
		// 指定源文件，目标目标，目标文件名
		ZipUtils.compress(new File("E:\\test"), "E:\\安装介质\\新建文件夹", "999");
	}

	@Test
	public void decompressTest() throws Exception {
		// 指定源文件解压
		//ZipUtils.decompress(new File("E:\\安装介质\\新建文件夹\\123.zip"));
		// 指定源文件路径解压
		//ZipUtils.decompress("E:\\安装介质\\新建文件夹\\123.zip");
		// 指定源文件，目标目录
		//ZipUtils.decompress(new File("E:\\安装介质\\新建文件夹\\123.zip"), new File("E:\\安装介质"));
		// 指定源文件，目标目录路径
		//ZipUtils.decompress(new File("E:\\安装介质\\新建文件夹\\123.zip"), "E:\\安装介质\\新建文件夹");
		//指定源文件路径，目标目录路径
		ZipUtils.decompress("E:\\安装介质\\新建文件夹\\123.zip", "E:\\安装介质\\新建文件夹");
	}
}