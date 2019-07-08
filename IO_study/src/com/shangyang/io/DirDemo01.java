package com.shangyang.io;

import java.io.File;

/**
 * 创建目录
 * 1.mkdir():确保上级目录存在，不存在则创建失败
 * 2.mkdirs()：上级目录可以不存在，不存在一同来创建
 * @author shangyang
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir = new File("dir");
		//boolean flag = dir.mkdir();
		//System.out.println(flag);
		System.out.println(dir.exists());
		System.out.println(dir.getAbsolutePath());
		boolean a = dir.delete();
		System.out.println(a);
	}
}
