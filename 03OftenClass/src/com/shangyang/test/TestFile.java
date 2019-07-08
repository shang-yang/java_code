package com.shangyang.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类的基本用法
 * @author shangyang
 *
 */
public class TestFile {

	public static void main(String[] args) throws IOException {
		 System.out.println(System.getProperty("user.dir"));
		 File f1 = new File("aaa.text");
		 f1.createNewFile();
		 
		 
		 File f = new File("aaa.text");
	        System.out.println("File是否存在："+f.exists());
	        System.out.println("File是否是目录："+f.isDirectory());
	        System.out.println("File是否是文件："+f.isFile());
	        System.out.println("File最后修改时间："+new Date(f.lastModified()));
	        System.out.println("File的大小："+f.length());
	        System.out.println("File的文件名："+f.getName());
	        System.out.println("File的目录路径："+f.getPath());
	}
}
