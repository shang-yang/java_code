package com.shangyang.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件拷贝
 * 使用文件字节输入流、文件字节输出流
 * @author shangyang
 *
 */
public class Copy {

	
	public static void main(String[] args) {
				//1.创建源
				File file = new File("/home/shangyang/桌面/a/c.txt");
				File file1 = new File("/home/shangyang/桌面/a/d.txt");
				//2.操作流
				InputStream  is = null;
				FileOutputStream os = null;
				try {
					is = new FileInputStream(file);
					os = new FileOutputStream(file1,true);
					//分段读取
					byte[] car = new byte[3];	//缓冲容器
					int len = -1;	//接收长度
					while((len=is.read(car)) != -1) {
						//字节数组 --> 字符串（解码）
						os.write(car, 0, len);
					}
					os.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						os.close();
						is.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
}
