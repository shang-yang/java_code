package com.shangyang.io;

import java.io.File;

/**
 * 打印子孙级目录和名称
 * @author shangyang
 *
 */
public class DirDemo03 {
	public static void main(String[] args) {
		File file = new File("/home/shangyang/桌面/黑马Python");
		printName(file,1);
	}
	public static void printName(File file,int deep) {
		for(int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(null == file || !file.exists()) {
			return ;
		} else if(file.isDirectory()) {
			for(File f:file.listFiles()) {
				printName(f,deep+1);
			}
		}
	}
}
