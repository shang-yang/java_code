package com.shangyang.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流
 * 理解操作步骤
 * 1.创建源
 * 2.操作流
 * 3.操作
 * 4.释放资源
 * @author shangyang
 *
 */
public class IOTest02 {

	public static void main(String[] args) {
		//1.创建源
		File file = new File("/home/shangyang/桌面/a/b.txt");
		//2.操作流
		InputStream  is = null;
		try {
			is = new FileInputStream(file);
			//分段读取
			byte[] car = new byte[3];	//缓冲容器
			int len = -1;	//接收长度
			while((len=is.read(car)) != -1) {
				//字节数组 --> 字符串（解码）
				String str = new String(car,0,len);
				System.out.print(str);
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
