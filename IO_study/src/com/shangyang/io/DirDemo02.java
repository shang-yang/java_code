package com.shangyang.io;

import java.io.File;

/**
 * 列出下一级
 * list():列出下一级名称
 * listFiles():列出下级File对象
 * @author shangyang
 *
 */
public class DirDemo02 {

	public static void main(String[] args) {
		File file = new File("/home/shangyang");
		
		String[] subNames = file.list();
		for(String s : subNames) {
			System.out.println(s);
		}
		System.out.println("****************************************8");
		File[] more = file.listFiles();
		for(File f:more) {
			System.out.println(f.getAbsolutePath());
		}
	}
}
