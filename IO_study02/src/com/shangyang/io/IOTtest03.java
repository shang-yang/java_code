package com.shangyang.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件字符输出流
 * @author shangyang
 *
 */
public class IOTtest03 {
	public static void main(String[] args) {
		File file = new File("/home/shangyang/桌面/a/e.txt");
		Writer os = null;
		try {
			os = new FileWriter(file,true);
			String msg = "Hello,world\nyou are very beautiful\n你看见我的小熊了么？\n";
			//写法一
			//char[] datas = msg.toCharArray();	//字符串-->字节数组
			//os.write(datas, 0, datas.length);
			
			//写法二
			os.write(msg);
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
