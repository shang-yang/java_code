package com.shangyang.io;

import java.io.File;

/**
 * 
 * @author shangyang
 *
 */
public class FileDemo {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));
		File file = new File("/home/shangyang/BZCXY/java_code/PlaneGame0.1/src/images/bg.jpg");
		System.out.println(file.getAbsolutePath());
		
		System.out.println("名称：" + file.getName());
		System.out.println("路径：" + file.getPath());
		System.out.println("绝对路径：" + file.getAbsolutePath());
		System.out.println("父路径：" + file.getParent());
		System.out.println("父对象：" + file.getParentFile().getName());
	}
}
