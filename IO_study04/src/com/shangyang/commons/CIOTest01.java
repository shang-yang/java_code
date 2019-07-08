package com.shangyang.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;

/**
 * 大小
 * @author shangyang
 *
 */
public class CIOTest01 {

	public static void main(String[] args) {
		//文件大小
		long len = FileUtils.sizeOf(new File("/home/shangyang/桌面/a.html"));
		System.out.println(len);
		//目录大小
		len = FileUtils.sizeOf(new File("/home/shangyang/桌面/a"));
		System.out.println(len);
	}
}
