package com.shangyang.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流
 * @author shangyang
 *
 */
public class IOTest05 {
	public static void main(String[] args) {
		File file = new File("/home/shangyang/桌面/a/c.txt");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file,true);
			String msg = "Hello,world\nyou are very beautiful\n";
			byte[] datas = msg.getBytes();	//字符串-->字节数组
			os.write(datas, 0, datas.length);
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
