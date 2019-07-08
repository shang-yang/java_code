package com.shangyang.commons;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * 拷贝
 * @author shangyang
 *
 */
public class CIOTest05 {

	public static void main(String[] args) throws IOException {
		//复制文件
		//FileUtils.copyFile(new File("bbb.txt"), new File("bbb_copy.txt"));
		//复制文件到目录
		//FileUtils.copyFileToDirectory(new File("bbb.txt"), new File("lib"));
		//复制文件夹,将其复制到文件夹下
		//FileUtils.copyDirectoryToDirectory(new File("lib"), new File("libs"));
		//复制文件夹，拷贝其内容
		//FileUtils.copyDirectory(new File("lib"), new File("libs"));
		//拷贝URL内容
		//FileUtils.copyURLToFile(new URL("http://www.baidu.com"), new File("a.html"));
		String datas = IOUtils.toString(new URL("http://www.163.com"),"gbk");
		System.out.println(datas);
	}
}
