package com.shangyang.commons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 读取文件
 * @author shangyang
 *
 */
public class CIOTest03 {

	public static void main(String[] args) throws IOException {
		//读取文件
		String msg = FileUtils.readFileToString(new File("/home/shangyang/桌面/a/b.txt"),"UTF-8");
		System.out.println(msg);
		byte[] datas = FileUtils.readFileToByteArray(new File("/home/shangyang/桌面/a/b.txt"));
		System.out.println(datas.length);
		System.out.println("************************************************");
		//逐行读取
		List<String> msgs = FileUtils.readLines(new File("/home/shangyang/桌面/a/b.txt"),"UTF-8");
		for(String string:msgs) {
			System.out.println(string);
		}
		System.out.println("************************************************");
		LineIterator it = FileUtils.lineIterator(new File("/home/shangyang/桌面/a/b.txt"),"UTF-8");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
	}
}
