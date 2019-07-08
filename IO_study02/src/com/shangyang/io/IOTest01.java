package com.shangyang.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 理解操作步骤
 * 1.创建源
 * 2.操作流
 * 3.操作
 * 4.释放资源
 * @author shangyang
 *
 */
public class IOTest01 {

	public static void main(String[] args) {
		//1.创建源
		File file = new File("/home/shangyang/桌面/a/b.txt");
		//2.操作流
		InputStream  is = null;
		try {
			 is = new FileInputStream(file);
			int temp;
			while((temp=is.read()) != -1) {
				System.out.println((char)temp);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
