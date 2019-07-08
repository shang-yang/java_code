package com.shangyang.io;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author shangyang
 *
 */
public class FileDemo02 {

	public static void main(String[] args) throws IOException {
		File file = new File("/home/shangyang/桌面/a/b.txt");
		boolean a = file.createNewFile();
		System.out.println(a);
		boolean b = file.delete();
		System.out.println(b);
	}
}
